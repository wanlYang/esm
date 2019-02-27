layui.use(['form', 'layer', 'jquery', "element"], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        element = layui.element,
        $ = layui.jquery;
    $('#verifyqq').click(function () {
        DJMask.open({
            width: "400px",
            height: "150px",
            title: "U袋网提示您：",
            content: "<b>该QQ不是客服-谨防受骗！</b>"
        });
    });
    // 顶部banner轮播
    var banner_swiper = new Swiper('.banner-box', {
        autoplayDisableOnInteraction: false,
        pagination: '.banner-box .swiper-pagination',
        paginationClickable: true,
        autoplay: 5000,
    });
    // 新闻列表滚动
    var notice_swiper = new Swiper('.notice-box .swiper-container', {
        paginationClickable: true,
        mousewheelControl: true,
        direction: 'vertical',
        slidesPerView: 10,
        autoplay: 2e3,
    });
    // 楼层导航自动 active
    $.scrollFloor();
    // 页面下拉固定楼层导航
    $('.floor-nav').smartFloat();
    $('.to-top').toTop({position: false});

    $.ajax({
        url: getRealPath() + "/category/list",
        type: 'GET',
        complete: function (XMLHttpRequest, textStatus) {

        },
        success: function (res) {
            var cateHtml = '';
            var flag = 0;
            $.each(res.data, function (index, item) {
                cateHtml += '<div class="cat-box">';
                cateHtml += '<div class="title">';
                cateHtml += '<i class="layui-icon layui-icon-component"></i> ' + item.title + '';
                cateHtml += '</div>';
                cateHtml += '<ul class="cat-list clearfix">';
                if (item.children != null) {
                    $.each(item.children, function (index, itemChild) {
                        flag += 1;
                        cateHtml += '<li>' + itemChild.title + '</li>';
                        console.log(flag)
                        if (flag == 4) {
                            return false;
                        }
                    })
                    flag = 0;
                }
                cateHtml += '</ul>';
                cateHtml += '<div class="cat-list__deploy">';
                cateHtml += '<div class="deploy-box">';
                $.each(item.children, function (index, itemChild) {
                    cateHtml += '<div class="genre-box clearfix">';
                    cateHtml += '<span class="title">' + itemChild.title + '</span>';
                    cateHtml += '<div class="genre-list">';
                    if (itemChild.children != null) {
                        $.each(itemChild.children, function (index, three) {
                            cateHtml += '<a href="">' + three.title + '</a>';
                        })
                    }
                    cateHtml += '</div>';
                    cateHtml += '</div>';
                })
                cateHtml += '</div>';
                cateHtml += '</div>';
                cateHtml += '</div>';
            })
            $("#categoryBox").html(cateHtml);
        },
        error: function () {
            layer.msg("出现错误,请尝试刷新页面!");
        }
    });
    //data为json数据
    //parent为要组合成html的容器
    function showAll(data, parent) {
        $.each(data.children, function (index, fatherLi) {//遍历数据集
            var li1 = $("<li class='" + fatherLi.liClass + "'><a href='" + fatherLi.link + "'><i class=" + fatherLi.iClass + "></i>" + fatherLi.label + "</a></li>");//没有children的初始li结构
            var li2 = $("<li class='" + fatherLi.liClass + "'><a href='" + fatherLi.link + "'><i class=" + fatherLi.iClass + "></i>" + fatherLi.label + "<span class='" + fatherLi.spanClass + "'><i class='" + fatherLi.spanChildIClass + "'></i></span>" + "</a></li>");//有children的初始li结构
            //console.log($(li1).html());
            //console.log($(li2).html());
            if (fatherLi.children.length > 0) { //如果有子节点，则遍历该子节点
                var ul = $("<ul class='" + fatherLi.children[0].ulClass + "'></ul>");
                $(li2).append(ul).appendTo(parent);//将li的初始化选择好，并马上添加带类名的ul子节点，并且将这个li添加到父亲节点中
                showAll(fatherLi.children[0], $(li2).children().eq(1));//将空白的ul作为下一个递归遍历的父亲节点传入，递归调用showAll函数
            } else {
                $(li1).appendTo(parent);//如果该节点没有子节点，则直接将该节点li以及文本创建好直接添加到父亲节点中
            }
        });
    }

})


