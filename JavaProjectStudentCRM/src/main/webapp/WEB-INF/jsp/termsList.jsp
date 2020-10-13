<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
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
            <div id="container">
                <section>
                    <div id="titleTermsList" class="row">
                        <div class="form">
                            <div class="form-row">
                                <div id="divFormTitle" class="form-group col-sm-4">
                                    <h5>Выбрать семестр:</h5>
                                </div>
                                <div class="form-group col-sm-3">
                                    <select type="text" id="select1" class="form-control">
                                        <c:forEach items="${terms}" var="t">
                                            <c:choose>
                                                <c:when test="${t.id eq selectedTerm.id}">
                                                    <option id="opt2" value="${t.id}"
                                                            selected>${t.name}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option id="opt2" value="${t.id}">${t.name}</option>
                                                </c:otherwise>
                                            </c:choose>

                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group col-sm-3">
                                    <button onclick="selectTermOnTermsList()" id="btn"
                                            class="btn btn-outline-secondary">
                                        Выбрать
                                    </button>
                                </div>
                            </div>
                            <div id="divDurationTerm" class="row">
                                <h5>
                                    <div class="col-sm-12">Длительность семестра: <b>${selectedTerm.duration}</b></div>
                                </h5>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="sectionBody">
                    <div class="row">
                        <div class="col-sm-7">
                            <h5>Список дисциплин семестра:</h5>
                            <table id="table" class="table table-bordered table table-hover">
                                <thead>
                                <tr>
                                    <th scope="col">Наименование дисциплины</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${disciplines}" var="d">
                                    <tr>
                                        <input type="hidden" value="${d.id}" id="discId" name="discId" selected> </option><td>${d.discipline}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-sm-3">
                            <admin-panel>
                                <div class="flex-container2">

                                    <c:if test="${role eq 1}">
                                    <div class="flex-item">
                                        <a href="/createTerm" class="btn btn-outline-info" role="button"
                                           aria-pressed="true">Создать семестр</a>
                                    </div>
                                    <div class="flex-item">
                                        <a onclick="modifySelectTerm()" class="btn btn-outline-info" role="button"
                                           aria-pressed="true">Изменить
                                            семестр</a>
                                    </div>
                                    <div class="flex-item">
                                        <a onclick="deleteSelectTerm()" class="btn btn-outline-info" role="button"
                                           aria-pressed="true">Удалить
                                            семестр</a>
                                    </div>
                                </div>
                                </c:if>
                            </admin-panel>
                        </div>
                    </div>
                </section>
            </div>
        </main-content>
    </div>
</div>

<form id="selectTerm" method="get" action="/termsList">
    <input type="hidden" id="idTerm" name="idTerm" value="">
</form>
<form id="delSelectTerm" method="post" action="/termsList">
    <input type="hidden" id="idDelTerm" name="idDelTerm" value="">
</form>
<<form id="formModifyingTerm" method="get" action="/modifyTerm">
<input type="hidden" id="idsOldDisciplines" name="idsOldDisciplines" value="">
<input type="hidden" id="idModifyTerm" name="idModifyTerm" value="">

</form>