layui.use(['form', 'layer', 'jquery',"element"], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        element = layui.element,
        $ = layui.jquery;
    $('#verifyqq').click(function() {
        DJMask.open({
            width:"400px",
            height:"150px",
            title:"U袋网提示您：",
            content:"<b>该QQ不是客服-谨防受骗！</b>"
        });
    });
    // 顶部banner轮播
    var banner_swiper = new Swiper('.banner-box', {
        autoplayDisableOnInteraction : false,
        pagination: '.banner-box .swiper-pagination',
        paginationClickable: true,
        autoplay : 5000,
    });
    // 新闻列表滚动
    var notice_swiper = new Swiper('.notice-box .swiper-container', {
        paginationClickable: true,
        mousewheelControl : true,
        direction : 'vertical',
        slidesPerView : 10,
        autoplay : 2e3,
    });
    // 楼层导航自动 active
    $.scrollFloor();
    // 页面下拉固定楼层导航
    $('.floor-nav').smartFloat();
    $('.to-top').toTop({position:false});



})


