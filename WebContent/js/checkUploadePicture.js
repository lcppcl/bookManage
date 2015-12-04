var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
function fileChange(target,id) {
    var fileSize = 0;
    var filetypes =[".jpg",".png",".jpeg",".PNG",".JPG",".JPEG"];
    var filepath = target.value;
    //ar filemaxsize = 1024*0.5;//0.5M
    var filemaxsize =500;//500kb
    if(filepath){
        var isnext = false;
        var fileend = filepath.substring(filepath.indexOf("."));
        if(filetypes && filetypes.length>0){
            for(var i =0; i<filetypes.length;i++){
                if(filetypes[i]==fileend){
                    isnext = true;
                    break;
                }
            }
        }
        if(!isnext){
            alert("上传图片格式不正确!");
            target.value ="";
            return false;
        }
    }else{
        return false;
    }
    if (isIE && !target.files) {
        var filePath = target.value;
        var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
        if(!fileSystem.FileExists(filePath)){
            alert("不存在，请重新输入！");
            return false;
        }
        var file = fileSystem.GetFile (filePath);
        fileSize = file.Size;
    } else {
        fileSize = target.files[0].size;
    }
    var size = fileSize / 1024;
    if(size>filemaxsize){
        alert("大小不能大于"+filemaxsize+"KB！");
        target.value ="";
        return false;
    }
    if(size<=0){
        alert("大小不能为0M！");
        target.value ="";
        return false;
    }
}

