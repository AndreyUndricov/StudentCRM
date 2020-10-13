<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<main>
    <div class="container">
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-md-11">
                <admin-panel>
                    <div class="flex-container1">
                        <div class="flex-item">
                            <a onclick="showMarksForSelectStudent()" class="btn btn-outline-info" role="button"
                               aria-pressed="true">Просмотр успеваемости</a>
                        </div>
                        <c:if test="${role eq 1}">
                        <div class="flex-item">
                            <a href="/createStudent" class="btn btn-outline-info" role="button"
                               aria-pressed="true">Создать студента</a>
                        </div>
                        <div class="flex-item">
                            <a onclick="modifySelectStudent()" class="btn btn-outline-info" role="button"
                               aria-pressed="true">Изменить
                                студента</a>
                        </div>
                        <div class="flex-item">
                            <a onclick="deleteSelectStudents()" class="btn btn-outline-info" role="button"
                               aria-pressed="true">Удалить
                                студента</a>
                        </div>
                    </div>
                    </c:if>
                </admin-panel>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-2">
            <nav>
                <div id="divNav" class="row">
                    <a id="home" href="/" class="btn btn-outline-secondary btn-sm">На главную</a>
                </div>
            </nav>
        </div>
        <div class="col-md-8">
            <main-content>
                <h3>Список студентов</h3>
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <c:if test="${role eq 1}">
                            <th></th>
                        </c:if>
                        <th>Фамилия</th>
                        <th>Имя</th>
                        <th>Группа</th>
                        <th>Дата зачисления</th>
                    </tr>
                    </thead>
                    <c:forEach items="${studs}" var="s">
                        <tr>
                            <c:if test="${role eq 1}">
                                <th>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="${s.id}"
                                               id="defaultCheck2">
                                    </div>
                                </th>
                            </c:if>
                            <th>
                                    ${s.firstName}
                            </th>
                            <th>
                                    ${s.lastName}
                            </th>
                            <th>
                                    ${s.group}
                            </th>
                            <th>
                                    ${s.date}
                            </th>
                        </tr>
                    </c:forEach>
                </table>
            </main-content>
        </div>
    </div>
</main>

<form id="formMarksStudent" method="get" action="/studentProgress">
    <input type="hidden" id="idStudentProgress" name="idStudentProgress" value="">
</form>
<form id="formModifyingStudent" method="get" action="/modifyStudent">
    <input type="hidden" id="idModifyStudent" name="idModifyStudent" value="">
</form>

<form id="formDeleteStudent" method="post" action="/students">
    <input type="hidden" id="idsDeleteStud" name="idsDeleteStud" value="">
</form>