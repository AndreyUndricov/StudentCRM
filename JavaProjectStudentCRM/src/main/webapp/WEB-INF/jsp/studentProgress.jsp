<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main>
    <div class="row">
        <div class="col-sm-2">
            <nav>
                <div id="divNav" class="row">
                    <a id="home" href="/" class="btn btn-outline-secondary btn-sm">На главную</a>
                    <a id="back" href="/students" class="btn btn-outline-secondary btn-sm">Назад</a>
                </div>

            </nav>
        </div>
        <div class="col-md-8">
            <main-content>
                <div class="container">
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <h3>Отображена успеваемость для следующего студента:</h3>

                            <table class="table">
                                <thead class="thead-dark">
                                <tr>
                                    <th>Фамилия</th>
                                    <th>Имя</th>
                                    <th>Группа</th>
                                    <th>Дата зачисления</th>
                                </tr>
                                </thead>
                                <tr>
                                    <input type="hidden" name="idModifyStud" value="${stud.id}">
                                    <Th>${stud.firstName}</Th>
                                    <Th>${stud.lastName}</Th>
                                    <Th>${stud.group}</Th>
                                    <th>${stud.date}</th>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <br>
                <div class="container">
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-6">
                            <table class="table">
                                <thead class="thead-dark">
                                <tr>
                                    <th>Дисциплина</th>
                                    <th>Оценка</th>
                                </tr>
                                </thead>
                                <c:forEach items="${markes}" var="m">
                                    <tr>
                                        <Th>${m.discipline}</Th>
                                        <Th>${m.graduate}</Th>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <div class="col-md-4">
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
                                                                <option id="opt1" value="${t.id}"
                                                                        selected>${t.name}</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option id="opt1" value="${t.id}">${t.name}</option>
                                                            </c:otherwise>
                                                        </c:choose>

                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group col-sm-3">
                                                <button onclick="selectTerm()" id="btn"
                                                        class="btn btn-outline-secondary">
                                                    Выбрать
                                                </button>
                                            </div>
                                        </div>
                                        <div id="divDurationTerm" class="row">
                                            <h5>
                                                <div class="col-sm-12">Длительность семестра:
                                                    <b>${selectedTerm.duration}</b>
                                                </div>
                                            </h5>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </main-content>
        </div>
    </div>
</main>
<form id="selectTerm" method="get" action="/studentProgress">
    <input type="hidden" id="idTerm" name="idTerm" value="">
    <input type="hidden" id="idSt" name="idSt" value="">
</form>