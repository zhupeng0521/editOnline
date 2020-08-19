var ntko;//控件对象
var logicalName;//文件名称
var fileId; //文件Id
var userName; //用户名称
var attCode; //附件编辑查看标识

//初始化去打开文档
function  init(cmd){
	cmd = decodeURI(cmd);//解码
	ntko = document.getElementById("TANGER_OCX");
	var cmdArr = cmd.split("@+");
	fileId = cmdArr[0];
	// logicalName = decodeURI(escape(cmdArr[1]));// 解码文件名称
	// document.getElementById("title").innerHTML=logicalName;
	userName = decodeURI(escape(cmdArr[2])); // 解码user
	attCode = decodeURI(escape(cmdArr[3])); // 解码附件编辑查看标识
	//alert(attCode+"//");
	//版增加对于PDF文件的支持
	if(window.navigator.platform=="Win64"){
		//alert("平台版文档控件，请使用32位浏览器如IE");	
		ntko.AddDocTypePlugin(".pdf","PDF.NtkoDocument","4.0.2.0","officecontrol/ntkooledocallx64.cab",51,true);	
	}else{
		ntko.AddDocTypePlugin(".pdf","PDF.NtkoDocument","4.0.2.0","officecontrol/ntkooledocall.cab",51,true);//版增加对于PDF文件的支持
	}
	//ntko.isoptforopenspeed = true; //设置下载本地打开，打开文档快一些
	//ntko.OpenFromURL("aboutus.docx");	
	logicalName = ntko.OpenFromURL("/editOnline/api/attach/down/"+fileId); //下载文档加载
	//ntko.OpenFromURL("http://192.168.8.227:8086/EditAttachment/aboutus.docx");	
	showSave();//控制显示保存按钮
}


//控制显示保存按钮
function showSave(){
    
	var closeElement = document.getElementById("close");
    var iCloseElement = document.createElement("i");
    iCloseElement.setAttribute("class","fa fa-times");
    closeElement.appendChild(iCloseElement)
      
	if(attCode == 1){
		var saveElement = document.getElementById("save");
	    var iSaveElement = document.createElement("i");
	    iSaveElement.setAttribute("class","fa fa-save");
	    saveElement.appendChild(iSaveElement)
	}
}

// 保存文档
function savefile(){
	var ret =ntko.savetourl("/editOnline/api/attach/upload/"+fileId,"fileUpload",logicalName,0);
	ntko.ActiveDocument.Saved = true;
	alert(ret);
}

//设置是否保留痕迹
function setReviewMode(boolvalue){
	if(ntko.DocType==1){
		ntko.ActiveDocument.TrackRevisions = boolvalue;//设置是否保留痕迹
		document.getElementById("setReviewMode"+boolvalue).className ="isChecked";
		document.getElementById("setReviewMode"+!boolvalue).className ="isNotChecked";
	}else{
		alert("此功能只在Word文档中生效!")
	}
} 

//设置是否显示痕迹
function setShowRevisions(boolvalue){
	if(ntko.DocType==1){
		ntko.ActiveDocument.ShowRevisions =boolvalue;//设置是否显示痕迹
		document.getElementById("setShowRevisions"+boolvalue).className ="isChecked";
		document.getElementById("setShowRevisions"+!boolvalue).className ="isNotChecked";
	}else{
		alert("此功能只在Word文档中生效!")
	}
}

//关闭插件
function closeWindow(){
	var isSaved = false; //是否保存 
	if(ntko.DocType==2){
		isSaved = ntko.ActiveDocument.Application.ActiveWorkbook.Saved; //excel 
	}else if(ntko.DocType==3){
		isSaved = ntko.ActiveDocument.Application.ActivePresentation.Saved; //ppt
	}else{
		isSaved = ntko.ActiveDocument.Saved;//word 或者 PDF
	}

	if(attCode == 2){
		isSaved = true;
	}
	
	if(isSaved == false){
		var isConfirm = confirm("文档修改后未保存，是否保存后关闭？");
		if(isConfirm) {
			savefile();//保存文档后关闭
			window.close();
		}else{
			window.close();
		}
	}else {
		window.close();
	}
}