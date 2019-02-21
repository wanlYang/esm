layui.use(['form', 'layer', 'jquery'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
    $ = layui.jquery;

    form.verify({
        password : function(value, item){
            if(value.length < 6){
                return "密码长度不能小于6位";
            }
        },
        confirmPass : function(value, item){
            if(!new RegExp($("#password").val()).test(value)){
                return "两次输入密码不一致,请重新输入!";
            }
        },
        phone : function (value, item) {
            if(!(/^1[34578]\d{9}$/.test(value))){
                return "手机号码有误，请重填";
            }
        }
    })

    $("#sendCode").unbind();

    //注册按钮
    form.on("submit(regist)", function (data) {
        console.log(data);

        return false;
    })



})
function sendCode() {
    console.log("验证码发送");
}

function isSendCode(phone){
    if(!(/^1[34578]\d{9}$/.test(phone))){
        $("#sendCode").unbind();
        $("#sendCode").addClass("layui-btn-disabled");
    }else{
        $("#sendCode").removeClass("layui-btn-disabled");
        $("#sendCode").bind("click",function () {
            sendCode();
        })
    }
}
