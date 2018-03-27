CREATE OR REPLACE FUNCTION public.insert_images(p_names              TEXT [], p_files TEXT [],
                                                p_up_load_article_id INT)
  RETURNS TEXT
LANGUAGE plpgsql
AS $$
DECLARE
  i      INT;
  nomber INT;
BEGIN
INSERT INTO public.article_images (name, file, up_load_article_id)
  SELECT
    u.*,
    p_up_load_article_id
      FROM public.get_name_file_table(p_names,p_files) u;
RETURN NULL;
END;
$$;

CREATE OR REPLACE FUNCTION public.get_name_file_table(p_names              TEXT [], p_files TEXT [])
  RETURNS TABLE(name text,file text)
LANGUAGE plpgsql
AS $$
BEGIN
  RETURN QUERY
  SELECT
    u.*
  FROM unnest(p_names, p_files) u;
END;
$$;

CREATE OR REPLACE FUNCTION public.save_upload_article(p_names TEXT [], p_files TEXT [],  p_description text,p_jotting text)
  RETURNS TEXT
LANGUAGE plpgsql
AS $$
DECLARE
  l_up_load_article_id      INT;
BEGIN
  INSERT INTO public.up_load_article (description, jotting) VALUES (p_description,p_jotting) RETURNING up_load_article_id into l_up_load_article_id;

  INSERT INTO public.article_images (name, file, up_load_article_id)
    SELECT
      u.*,
      l_up_load_article_id
    FROM public.get_name_file_table(p_names,p_files) u;
  RETURN NULL;
END;
$$;