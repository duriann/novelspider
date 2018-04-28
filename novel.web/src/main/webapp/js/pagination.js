(function(){
    var comm = {
        /**
         * 全局配置
         */
        config:{
                currentPage:1,
                pageSize:10,
        },
        render:{
            renderPage:function (keyword) {
                var currentPage = comm.config.currentPage;
                var totalPage = comm.config.totalPage;
                var pageSize = comm.config.pageSize;
                $("#currentPage").html("第"+currentPage+"/"+totalPage);

                currentPage==1? $("#previousPage").attr("disabled",true): $("#previousPage").attr("disabled",false);
                currentPage==totalPage?$("#nextPage").attr("disabled",true): $("#nextPage").attr("disabled",false);

                $("#nextPage").attr("value",currentPage+1);
                $("#nextPage").attr("keyword",keyword);
                $("#nextPage").attr("pageSize",pageSize);

                $("#previousPage").attr("value",currentPage-1);
                $("#previousPage").attr("keyword",keyword);
                $("#previousPage").attr("pageSize",pageSize);


                $("#lastPage").attr("value",totalPage);
                $("#lastPage").attr("keyword",keyword);
                $("#lastPage").attr("pageSize",pageSize);

                $("#gotoPage").attr("keyword",keyword);
                $("#gotoPage").attr("pageSize",pageSize);

                $("#firstPage").attr("keyword",keyword);

            }
        }

    }

    var api = new Object();
    api.config = comm.config;
    api.render = comm.render;
    if (window.Page == null) {
        window.Page= new Object();
    }
    Page = api;
})();
