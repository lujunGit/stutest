var env={
    version:"Copyright © 2017 北京数人科技有限公司 Console: master-SNAPSHOT"
}

window.onload = function(){
    var version = $("#versionId").get(0);
    alert(version);
    $("#versionId").text(env.version);
}