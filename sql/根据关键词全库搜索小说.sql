select
    id, name, author, url, type, last_update_chapter, last_update_chapter_url, last_update_time, 
    status, first_letter, platform_id, add_time
    from tbl_novel
    where name like "盘%" or author like "盘%"