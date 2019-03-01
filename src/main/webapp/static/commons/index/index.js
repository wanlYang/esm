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

    //获取导航数据
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

    $.ajax({
        url: getRealPath() + "/index/hot/product",
        type: 'GET',
        complete: function (XMLHttpRequest, textStatus) {

        },
        success: function (result) {


        },
        error: function () {
            layer.msg("出现错误,请尝试刷新页面!");
        }
    });

})


