/**
 * 
 */
//게시물 조회 ajax로.................................................................	
function viewData(bno, page) {
	
		var div = document.getElementById("ajaxRead_"+bno);
		if(div.innerHTML !== ""){
			div.innerHTML = "";	
			document.pageForm.page.value = page;
			document.pageForm.method = "get";
			document.pageForm.action = "bbsList?page="+page;
			document.pageForm.submit(); //조회를 하고 다시 닫을때 조회수가 올라가지 않는다. 
										//그래서 다시 닫을때 페이지를 유지하여
									    //그페이지번호로 리스트를 다시 요청하는 방식
			return;
		}
	
		var xhr = (typeof XMLHttpRequest != 'undefined') ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');
		xhr.open('GET', '/bbs/bbsRead?bno='+bno, false);
	 	
		xhr.onreadystatechange = function() {// 비동기를할때 이벤트를 쓰기때문에 콜백을 쓴다.
	    	var status;
	    	var data;
	    	if (xhr.readyState == 4) { 
	      		status = xhr.status;
	     		 if (status == 200) {
	        		data = xhr.responseText; // 이 안의 내용이 이벤트가 된다.
	        		//document.getElementById("ajaxRead").innerHTML = data;
	        		div.innerHTML = data;
	     		 } else {
	        		alert("실패");
	      		}
	    	}
		};
	  xhr.send();
}  
//게시물 수정할 페이지를 ajax로 가져오기.......................................................................
function updateData(bno) {	
	
	var div = document.getElementById("ajaxRead_"+bno);
	var xhr = (typeof XMLHttpRequest != 'undefined') ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');
	xhr.open('GET', '/bbs/bbsUpdate?bno='+bno, false);
 	
	xhr.onreadystatechange = function() {
    	var status;
    	var data;
    	if (xhr.readyState == 4) { 
      		status = xhr.status;
     		 if (status == 200) {
        		data = xhr.responseText; 
        		div.innerHTML = data;
     		 } else {
        		alert("실패");
      		}
    	}
	};
  xhr.send();
}
//게시물 등록할 페이지를 ajax로 가져오기......................................................................
function writeData() {	
	
	var div = document.getElementById("ajaxAdd");
	var xhr = (typeof XMLHttpRequest != 'undefined') ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');
	xhr.open('GET', '/bbs/bbsAdd', false);
 	
	xhr.onreadystatechange = function() {
    	var status;
    	var data;
    	if (xhr.readyState == 4) { 
      		status = xhr.status;
     		 if (status == 200) {
        		data = xhr.responseText; 
        		div.innerHTML = data;
     		 } else {
        		alert("실패");
      		}
    	}
	};
  xhr.send();
}
//게시물 검색..........................................................................
function goSearch(){

	document.pageForm.page.value=1
//	document.pageForm.page.value = page;
	document.pageForm.method = "get";
	document.pageForm.action = "bbsList";
	document.pageForm.submit();
}
//게시물 삭제........................................................................
function deleteData(bno){
	document.pageForm.method = "get";
	document.pageForm.action = "bbsDelete";
	document.pageForm.bno.value = bno;
	
	if(confirm('정말 삭제하시겠습니까?') == true) {
		document.pageForm.submit();
	} else {
		return;
	}
	
	
}
//게시물 등록......................................................................
function writeActionData() {
	var fileList = [];

	var thumb = document.getElementsByClassName("thumb");
	
/*	console.log(thumb.length);
	console.log(thumb[0]);*/
	
	for(var i=0; i<thumb.length; i++) {
		fileList.push(thumb[i].getAttribute("data-src"));
	}
	console.log(fileList[0]);
	
	document.addForm.method = "post";
	document.addForm.action = "bbsAddAction";
	document.addForm.fileList.value = fileList;  
	document.addForm.submit();
}
//게시물 수정....................................................................
function updateActionData() {
	document.updateForm.method = "post";
	document.updateForm.action = "bbsUpdateAction";
	document.updateForm.submit();
}
//ajax로 가져온 부분만 없애줌으로서 뒤로가기 기능...............................................
function before() {
	var div = document.getElementById("ajaxAdd");
	if(div.innerHTML !== ""){
		div.innerHTML = "";		
		return;
	}
}
//댓글 리스트 ajax로 가져오기..................................................................................
function replyData(bno) {
	
	var div = document.getElementById("replyList");
	if(div.innerHTML !== ""){
		div.innerHTML = "";	
		return;
	}

	var xhr = (typeof XMLHttpRequest != 'undefined') ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');
	xhr.open('GET', '/reply/list?bno='+bno, false);
 	
	xhr.onreadystatechange = function() {// 비동기를할때 이벤트를 쓰기때문에 콜백을 쓴다.
    	var status;
    	var data;
    	if (xhr.readyState == 4) { 
      		status = xhr.status;
     		 if (status == 200) {
        		data = xhr.responseText; // 이 안의 내용이 이벤트가 된다.
        		//document.getElementById("ajaxRead").innerHTML = data;
        		div.innerHTML = data;
     		 } else {
        		alert("실패");
      		}
    	}
	};
  xhr.send();
}  
//댓글 추가....................................................................................
function replyInput(bno) {
	document.replyForm.bno.value = bno;
	document.replyForm.method = "post";
	document.replyForm.action = "/reply/add";
	document.replyForm.submit();
}

//댓글 수정.......................................................................
function reUpdate(rno) {
	
	var div = document.getElementById("reply_"+rno);
	console.log(div.id)
	//var reply = div.firstChild.nodeValue;
	var reply = document.getElementById("content_"+rno).value;
	console.log(reply);
	if(reply !== null) {
		div.innerHTML = "<input id='mod_reply(" + rno + ")' type='text' value='" + reply + "' />"
						//+ "<input type='button' value='수정 완료' onclick='javascript:reUpdateAction()' />"
						+ "<input id='mod_rno(" + rno + ")' type='hidden' value='" + rno + "' />"
		                /*+ "<button id='replyUpdate'>수정 완료</button>";*/
						+ "<input type='button' value='수정 완료' onclick='javascript:reUpdateAction(" + rno + ")' />";
		
		
		
/*		var head= document.getElementsByTagName('head')[0];
        var script= document.createElement('script');
        script.type= 'text/javascript';
        script.innerHTML = "EventUtil.addHandler(replyUpdate, 'click', function(event){" + 
        						"reUpdateAction();" +
        					"})";
        head.appendChild(script);*/
	}
}

//댓글 수정 동작............................................................................
function reUpdateAction(rno) {
	//var form = document.getElementById("replyContentForm_${rno}_"+rno);
	var rno = document.getElementById('mod_rno(' + rno + ')').value; //객체가아니라 .value를해주어서 값을 가져와야했다!!!!!
	var reply = document.getElementById('mod_reply('+ rno +')').value;
	
	//alert("reUpdateAction()동작 " + rno + " : " + reply);
	
	document.replyContentForm.rno.value = rno;
	document.replyContentForm.reply.value = reply;
	document.replyContentForm.method = "POST";
	document.replyContentForm.action = "/reply/update";
	document.replyContentForm.submit();
}

//댓글 삭제........................................................................................
function reDelete(rno) {
	//var form = document.getElementById("replyContentForm_${rno}_"+rno);
	document.replyContentForm.rno.value = rno;
	document.replyContentForm.method ="get";
	document.replyContentForm.action = "/reply/delete";
	
	if(confirm('정말 삭제하시겠습니까?') == true) {
		document.replyContentForm.submit();
	} else {
		return;
	}		
	
}


//댓글 리스트(jason) ajax로 가져오기..........................................................................
function jsonData(bno) {
	
	var div = document.getElementById("replyList");
	if(div.innerHTML !== ""){
		div.innerHTML = "";	
		return;
	}

	$.ajax({
		type : "GET",
		url : "/reply/json?bno="+bno,
		//dataType : "JSON",
		success : function(data) {	
			
			console.log(data);
			
			var content = "<form class='reply' name='replyContentForm' >"
						  + "<input name='rno' type='hidden' />"
						  + "<input name='bno' type='hidden' />"
						  + "<input name='replyer' type='hidden' />"
						  + "<input name='reply' type='hidden' />";
			
			$.each(data, function(idx, key) {
				content += "<h6><strong>" + key.replyer + "</strong>";
				content += "<small>" + key.regdate + "</small>";
				content += "<strong>" + key.rno + "</strong></h6>";
				content += "<input id='content_" + key.rno + "' type='hidden' value='" + key.reply + "'/>"
				content += "<div id='reply_" + key.rno + "'>";
				if(key.lately < 2) {
					content += "<span class='label label-warning'> New </span> &nbsp;&nbsp";
				}
				content +=  key.reply + "</div>";
				content += "<input type='button' value='수정' onclick='javascript:reUpdate(" + key.rno + ")' />";
				content += "<input type='button' value='삭제' onclick='javascript:reDelete(" + key.rno + ")' />";
			})	
			content += "</form>";
			$("#replyList").html(content);
		}
	});
	
}

//reUpdateAction()함수를 사용하지 않기위한 댓글 수정.....................................................
function reJasonUpdate(rno) {
	
	var div = document.getElementById("reply_"+rno);
	console.log(div.id)
	var reply = div.firstChild.nodeValue;
	console.log(reply);
	if(reply !== null) {
		div.innerHTML = "<input id='mod_reply(" + rno + ")' type='text' value='" + reply + "' />"
						//+ "<input type='button' value='수정 완료' onclick='javascript:reUpdateAction()' />"
						+ "<input id='mod_rno(" + rno + ")' type='hidden' value='" + rno + "' />"
		                /*+ "<button id='replyUpdate'>수정 완료</button>";*/
						+ "<input type='button' value='수정 완료' onclick='javascript:reJasonUpdateAction(" + rno + ")' />";
	}
}

//화면 전환 없이 댓글수정............................................................................
function reJasonUpdateAction(rno) {

	var rno = document.getElementById('mod_rno(' + rno + ')').value; //객체가아니라 .value를해주어서 값을 가져와야했다!!!!!
	var reply = document.getElementById('mod_reply('+ rno +')').value;
		
	document.replyContentForm.rno.value = rno;
	document.replyContentForm.reply.value = reply;
	
	console.log($(".reply").serialize());
	
	var target = $("#replyList");
	
	$.post("/reply/json", $(".reply").serialize(), function(data) {
		console.log(data);
		
		var content = "<form class='reply' name='replyContentForm' >"
					  + "<input name='rno' type='hidden' />"
					  + "<input name='bno' type='hidden' />"
					  + "<input name='replyer' type='hidden' />"
					  + "<input name='reply' type='hidden' />";
		
		$.each(data, function(idx, key) {
			content += "<h6><strong>" + key.replyer + "</strong>";
			content += "<small>" + key.regdate + "</small>";
			content += "<strong>" + key.rno + "</strong></h6>";
			content += "<div id='reply_" + key.rno + "'>" + key.reply + "</div>";
			content += "<input type='button' value='수정' onclick='javascript:reJasonUpdate(" + key.rno + ")' />";
			content += "<input type='button' value='삭제' onclick='javascript:reDelete(" + key.rno + ")' />";
		})	
		content += "</form>";
		$("#replyList").html(content);
     });
	
}

//파일 업로드.........................................................................................
/*function uploadFile() {
	
	var xhr = (typeof XMLHttpRequest != 'undefined') ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');
	xhr.open('GET', '/file/upload', false);
 	
	xhr.onreadystatechange = function() {
    	var status;
    	var data;
    	if (xhr.readyState == 4) { 
      		status = xhr.status;
     		 if (status == 200) {
        		data = xhr.responseText; 
        		div.innerHTML = data;
     		 } else {
        		alert("실패");
      		}
    	}
	};
  xhr.send();
	
}*/

function updateResult(data) {

	console.log(data);
	//$(".attachList").append("<input type='hidden' name=contfile value='"+data.fileName+"'></p>");
		
	if(data.suffix == '.jpg') {
		//$(".attachList").append("<p><a href='/file/down?src="+data.fileName+"'><image class='thumb' data-src='"+data.fileName+"' src='/file/view/"+data.fileName+"'/></p>");
		$(".attachList").append("<div><image class='thumb' data-src='"+data.fileName+"' src='/file/view/"+data.fileName+"'/><strong>" + data.originName + "</strong></div>");
	} else {
		//$(".attachList").append("<p><a href='/file/down?src="+data.fileName+"'><image class='thumb' data-src='"+data.fileName+"' src='/resources/images/iconsets9.jpg'/></a></p>");
		$(".attachList").append("<div><image class='thumb' data-src='"+data.fileName+"' src='/resources/images/iconsets9.jpg'/><strong>" + data.originName + "</strong></div>");
	}

}



















	 