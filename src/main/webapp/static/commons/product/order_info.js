layui.use(['form', 'layer','flow', 'jquery', "element",'carousel'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        element = layui.element,
        $ = layui.jquery,
        carousel = layui.carousel,
        flow = layui.flow;
    form.on('submit(pay)',function (data) {
        $(this).html("请稍后...").attr("disabled", "disabled").addClass("layui-disabled");
        var index = layer.msg('支付中,请稍候', {
            icon: 16,
            time: false,
            shade: 0.8
        });
        $.ajax({
            url: getRealPath() + "/order/pay",
            type: 'POST',
            complete: function (XMLHttpRequest, textStatus) {
                layer.close(index);
            },
            data:data.field,
            success: function (result) {
                console.log(result);
                if (result.status == 200) {
                    layer.msg(result.message);
                    setTimeout(function () {
                    location.reload();
                    },500);
                }else{
                    layer.msg(result.message);
                }
            },
            error: function () {
                layer.msg("出现错误,请尝试刷新页面!");
            }
        });

        return false;
    })

    form.on('submit(confirm)',function (data) {
        console.log(data.field);
        $(this).html("请稍后...").attr("disabled", "disabled").addClass("layui-disabled");
        var index = layer.msg('确认收货中,请稍候', {
            icon: 16,
            time: false,
            shade: 0.8
        });
        $.ajax({
            url: getRealPath() + "/order/confirm",
            type: 'POST',
            complete: function (XMLHttpRequest, textStatus) {
                layer.close(index);
            },
            data:data.field,
            success: function (result) {
                console.log(result);
                if (result.status == 200) {
                    layer.msg(result.message);
                    setTimeout(function () {
                        location.reload();
                    },500);
                }else{
                    layer.msg(result.message);
                }
            },
            error: function () {
                layer.msg("出现错误,请尝试刷新页面!");
            }
        });
        return false;
    })
})


