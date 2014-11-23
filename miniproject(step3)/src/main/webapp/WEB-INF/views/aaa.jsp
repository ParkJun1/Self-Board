<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>${vo.title}</title>
</head>
<body>
   <h1>${vo.title }</h1>
   글쓴이 : ${vo.userid }   작성일 : ${vo.regdate }
   <br>
   <p>${vo.cont }</p>
   <br>
   
   <button><a href="uboard?bno=${vo.bno }">수정</a></button>
   <button><a href="delete?bno=${vo.bno }">삭제</a></button>
   
   <form class="replyForm">
      <p>덧글을 작성하세요</p>
      작성자<input type="text" name="userid" value="han00">
      덧글내용<input type="text" name="cont" value="덧글">
      <input type="hidden" name="bno" value=${vo.bno }>
   </form>
   
   <button class="putReply">리플달긔</button>
   
   <div class="bbs"></div>
   
   <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
   <script>
      $(document).ready(replyList());
      console.log($(".replyForm").serialize());
   
       $(".putReply").on("click", replyAction);
      
       function replyAction(){
           /* url = "reply/list?bno=" + ${vo.bno} + "&cont=" + document.replyForm.cont.value + "&userid=" + document.replyForm.userid.value; */
           /* url = "reply/list" + $(".replyForm").serialize();
           replyList(url); */
           //var $reply = $("#reply");
           //var $line = $("#line")
           alert("되냐고");
           var target = $(".bbs");
           /* target.removeChild(target.line); */
           $.post("reply/create", $(".replyForm").serialize(), function(data){
              console.log(data);
              var items = [];
              var content = "";
            $.each(data, function (key, val) {
               console.log(key, val);
               //items.push("<ul><li>"+val.cont+"</li></ul>")
               content += "<ul><li>"+val.cont+"</li></ul>";
               /* items.push("<ul id='" + key + "'>"
                  +("<li class=\"bno\">"+val.bno+"</li>")
                  +("<li class=\"readtitle\"><a href='read?bno="+val.bno+"'>"+val.title+"</a></li>")
                  +("<li class=\"writer\">"+val.userid+"</li>")
                  +("<li class=\"writedate\">"+val.regdate+"</li>")
                  +("<li class=\"viewcount\">"+val.vcount+"</li>")+"</ul>")   */
            });
            
/*              $("<div/>", {
               "class": "line",
               html: items.join("")
            }).appendTo(target); */
             
            target.html(content);
           });
       }
   
      
      function replyList(){
         var url = "reply/list?bno=" + ${vo.bno};
         var target = $(".bbs");
         $.getJSON(url, function (data) {
            var items = [];
            $.each(data, function (key, val) {
               console.log(key, val);
               items.push("<ul><li>"+val.cont+"</li></ul>")
               /* items.push("<ul id='" + key + "'>"
                  +("<li class=\"bno\">"+val.bno+"</li>")
                  +("<li class=\"readtitle\"><a href='read?bno="+val.bno+"'>"+val.title+"</a></li>")
                  +("<li class=\"writer\">"+val.userid+"</li>")
                  +("<li class=\"writedate\">"+val.regdate+"</li>")
                  +("<li class=\"viewcount\">"+val.vcount+"</li>")+"</ul>")   */
            });
            $("<div/>", {
               "class": "line",
               html: items.join("")
            }).appendTo(target);
         });
      }
   </script>
</body>
</html>