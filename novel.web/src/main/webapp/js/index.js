$(function () {
    $("#btnSearch").click(search);
    $("#keyword").click(function (e) {
        $("#keyword").select();
    });
    $("#keyword").keydown(function (e) {
        if (e.keyCode == 13) {
            search();
        }
    });
    $("#nextPage").click(function () {
        var nextPage = $("#nextPage").val();
        var pageSize = $("#nextPage").attr("pageSize");
        var keyword = $("#nextPage").attr("keyword");
        searchByKeyword(keyword,nextPage,pageSize);
    });

    $("#previousPage").click(function () {
        var prevPage = $("#previousPage").val();
        var pageSize = $("#previousPage").attr("pageSize");
        var keyword = $("#previousPage").attr("keyword");
        searchByKeyword(keyword,prevPage,pageSize);
    });

    $("#lastPage").click(function () {
        var lastPage = $("#lastPage").val();
        var pageSize = $("#lastPage").attr("pageSize");
        var keyword = $("#lastPage").attr("keyword");
        searchByKeyword(keyword,lastPage,pageSize);
    });

    $("#gotoPage").click(function () {
        var gotopage_text =  $("#gotopage_text").val();
        var pageSize = $("#gotoPage").attr("pageSize");
        var keyword = $("#gotoPage").attr("keyword");
        searchByKeyword(keyword,gotopage_text,pageSize);
    });

    $("#firstPage").click(function () {
        var keyword = $("#firstPage").attr("keyword");
        searchByKeyword(keyword,1,10);
    });

});

function search() {
    var currentPage = 1,pageSize = 10;
    var keyword = $("#keyword").val().trim();
    if (!keyword) {
        console.warn("没有输入关键词，不搜索");
        return;
    }
    if (keyword.indexOf("www") == 0) {
        keyword = "http://" + keyword;	//协议补全
    }
    if (keyword.indexOf("http") == 0) {
        console.log(keyword + "\t是一个网页，直接跳转");
        searchByUrl(keyword);
    } else {
        console.log(keyword + "\t是普通关键词，去搜索");
        searchByKeyword(keyword,currentPage,pageSize);
    }
}

function searchByUrl(url) {
    window.open("./chapterList?base64Url=" + $.base64.encode(url))
}

function searchByKeyword(keyword,currentPage,pageSize) {
    $.ajax({
        url: "./novel/searchByPage",
        type: "post",
        dataType: "json",
        data: {
            "keyword": keyword,
            "currentPage":currentPage,
            "pageSize":pageSize
        },
        error: function (data) {

        },
        success: function (data) {
            if (data.status == 1) {
                console.log(data);
                var $novels = data.data.pages;
                $("#list").html("");
                $.each($novels, function (index, novel) {
                    $("#list").append(createNovelTr(index, novel));
                });

                $("#page").show();
                var currentPage = data.data.currentPage;
                var totalPage = data.data.totalPage;
                $("#currentPage").html("第"+currentPage+"/"+totalPage);
                if(currentPage==1){
                    $("#previousPage").attr("disabled",true);
                }else{
                    $("#previousPage").attr("disabled",false);
                    $("#previousPage").attr("value",currentPage-1);
                }
                if(currentPage==totalPage){
                    $("#nextPage").attr("disabled",true);
                }
               // $("#previousPage").click(searchByKeyword(keyword,currentPage-1,pageSize));
                $("#nextPage").attr("value",currentPage+1);
                $("#nextPage").attr("keyword",keyword);
                $("#nextPage").attr("pageSize",pageSize);


                $("#previousPage").attr("keyword",keyword);
                $("#previousPage").attr("pageSize",pageSize);

                $("#lastPage").attr("value",totalPage);
                $("#lastPage").attr("keyword",keyword);
                $("#lastPage").attr("pageSize",pageSize);

                $("#gotoPage").attr("keyword",keyword);
                $("#gotoPage").attr("pageSize",pageSize);

                $("#firstPage").attr("keyword",keyword);



            } else if (data.status == 0) {
                console.log(data.desc);
            } else {

            }
        }
    });

    function createNovelTr(index, novel) {
        var trHtml = '<tr>'
            + '		<td>' + (index + 1) + '</td>'
            + '		<td><a href="./novel/getChapters?base64Url=' + $.base64.encode(novel.url) + '" target="_blank">' + novel.name + '</a></td>'
            + '		<td>' + novel.author + '</td>'
            + '		<td><a href="./novel/getChapterDetail?url=' + novel.lastUpdateChapterUrl + '" target="_blank">' + novel.lastUpdateChapter + '</a></td>'
            + '		<td>' + ((novel.writingState == 1) ? "连载" : "完结") + '</td>'
            + '	    <td>' + getPlatform(novel.platformId) + '</td>'
            + '</tr>';
        return $(trHtml);
    }

    function getPlatform(platformId) {
        if (platformId == 1) {
            return "顶点小说";
        } else if (platformId == 2) {
            return "笔趣阁";
        } else if (platformId == 4) {
            return "看书中";
        } else if (platformId == 3) {
            return "笔下文学";
        } else {
            return "为知";
        }
    }
}