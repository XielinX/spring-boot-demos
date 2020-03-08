/**
 * 打开一个窗口
 * @param url 跳转窗口url
 * @param width 展示窗口宽度
 * @param height 展示窗口高度
 */
function openWindow(url,width,height) {
    width = width || 600;
    height = height || 400;
    const left = (window.screen.width - width) / 2;
    const top = (window.screen.height - height) / 2;
    window.open(url, "_blank", "toolbar=yes, location=yes, directories=no, status=no, menubar=yes, scrollbars=yes, resizable=no, copyhistory=yes, left="+left+", top="+top+", width="+width+", height="+height);
}

function qqLogin()
{
    const qqAppId = '1110316944'; // 上面申请得到的appid
    const redirect_uri = 'http://localhost:8887/callbackToQQ'; // 前面设置的回调地址
    const state = 'fjdslfjsdlkfd'; // 防止CSRF攻击的随机参数，必传，登录成功之后会回传，最好后台自己生成然后校验合法性
    openWindow(`https://graph.qq.com/oauth2.0/authorize?response_type=token&client_id=${qqAppId}&redirect_uri=${encodeURIComponent(redirect_uri)}&state=${state}`);
}
