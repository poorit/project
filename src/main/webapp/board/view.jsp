<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>게시물 상세보기</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/common.css">
<script src="../js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
<h1>게시물 상세보기</h1>
<c:choose>
<c:when test="${board != null}">
<form class="form-horizontal" action='update.do' method='post'>
<div class="form-group">
    <label for="no" class="col-sm-2 control-label">번호</label>
    <div class="col-sm-10">
      <input id="no" class="form-control" name='no' type='text' readonly value='${board.no}'>     
    </div>
  </div>
  <div class="form-group">
    <label for="title" class="col-sm-2 control-label">제목</label>
    <div class="col-sm-10">
    <input id="title" class="form-control" name='title' type='text' value='${board.title}'>
    </div>
  </div>
  <div class="form-group">
    <label for="contents" class="col-sm-2 control-label">내용</label>
    <div class="col-sm-10">
    <textarea id='contents' class="form-control" name='contents' rows="10">${board.contents}</textarea>
    </div>
  </div>
      
	 조회수: ${board.count}<br>
	 등록일: ${board.createDate}<br>
	    <button type='submit' class="btn btn-primary">변경</button>
	    <button type='button' class="btn btn-primary"onclick='onDelete(${board.no})'>삭제</button>
	    <button type='button' class="btn btn-primary">취소</button>
	 </form>
	 <script>
	 function onDelete(no){
	 location.href='delete.do?no=' + no;
   }
	 
</script>
</c:when>
<c:otherwise>
<p>존재하지 않는 게시물입니다.</p>
</c:otherwise>
</c:choose>
</div>
</body></html>
