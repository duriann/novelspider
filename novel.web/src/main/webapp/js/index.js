$(function() {
    $("#btnSearch").click(search);
    $("#keyword").click(function(e) {
        $("#keyword").select();
    });
    $("#keyword").keydown(function(e) {
        if (e.keyCode == 13) {
            search();
        }
    });
});
function search() {
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
        searchByKeyword(keyword);
    }
}
function searchByUrl(url) {
    window.open("./chapterList?base64Url=" + $.base64.encode(url))
}
function searchByKeyword(keyword) {
    $.ajax({
        url:"/novel/search",
        type:"post",
        dataType:"json",
        data:{
            "keyword":keyword,
        },
        error:function(data) {

        },
        success:function(data) {
            if (data.status == 1) {
                var $novels = data.data;
                $("#list").html("");
                $.each($novels, function(index, novel) {
                    $("#list").append(createNovelTr(index, novel));
                });
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
            + '		<td><a href="./chapterList?base64Url=' + novel.lastUpdateChapterUrl + '" target="_blank">' + novel.lastUpdateChapter + '</a></td>'
            + '		<td>' + ((novel.writingState == 1) ? "连载" : "完结") + '</td>'
            + '	    <td>' +  getPlatform(novel.platformId) + '</td>'
            + '</tr>';
        return $(trHtml);
    }
    function getPlatform(platformId) {
        if (platformId == 1) {
            return "顶点小说";
        } else if (platformId == 2) {
            return "笔趣阁";
        } else if (platformId == 3) {
            return "看书中";
        } else if (platformId == 4) {
            return "笔下文学";
        } else {
            return "为知";
        }
    }
}