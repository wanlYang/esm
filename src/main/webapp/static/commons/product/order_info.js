layui.use(['form', 'layer','flow', 'jquery', "element",'carousel'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        element = layui.element,
        $ = layui.jquery,
        carousel = layui.carousel,
        flow = layui.flow;
    $(this).on('change','input',function() {
        $(this).parents('.radio-box').addClass('active').siblings().removeClass('active');
    })
})


