 select
       p.name
        from tbl_role r,tbl_user_role ur,tbl_user u,tbl_permission p,tbl_role_permission rp
        where
         u.id=ur.user_id and ur.role_id=r.id and rp.role_id=r.id and rp.permission_id=p.id and u.id=1