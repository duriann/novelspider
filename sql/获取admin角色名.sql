 select
        r.name
        from tbl_role r,tbl_user_role ur,tbl_user u
        where
        r.id=ur.id and u.id=ur.id and u.name="admin"