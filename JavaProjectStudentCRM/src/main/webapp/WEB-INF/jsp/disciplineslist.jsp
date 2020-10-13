<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<main>
    <div class="row">
        <div class="col-sm-2">
            <nav>
                <div id="divNav" class="row">
                    <a id="home" href="/" class="btn btn-outline-secondary btn-sm">На главную</a>
                </div>
            </nav>
        </div>
        <div class="col-md-8">
            <admin-panel>
                <c:if test="${role eq 1}">
                    <div class="flex-container">
                        <div class="flex-item item-0">
                            <a href="./disciplinecreating" class="btn btn-outline-info" role="button"
                               aria-pressed="true">Создать дисциплину</a>
                        </div>
                        <div class="flex-item item-1">
                            <a onclick="modifySelectDiscipline()" class="btn btn-outline-info" role="button"
                               aria-pressed="true">Изменить дисциплину</a>
                        </div>
                        <div class="flex-item item-2">
                            <a onclick="deleteSelectDisciplines()" class="btn btn-outline-info" role="button"
                               aria-pressed="true">Удалить дисциплины</a>
                        </div>
                    </div>
                </c:if>
            </admin-panel>

            <main-content>
                <h3>Список дисциплин</h3>
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <c:if test="${role eq 1}">
                            <th></th>
                        </c:if>
                        <th>Название дисциплины</th>
                    </tr>
                    </thead>
                    <c:forEach items="${disces}" var="d">
                        <tr>
                            <c:if test="${role eq 1}">
                                <th>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="${d.id}"
                                               id="defaultCheck">
                                    </div>
                                </th>
                            </c:if>
                            <th>
                                    ${d.discipline}
                            </th>
                        </tr>

                    </c:forEach>

                </table>



            </main-content>
        </div>
        <div class="col-md-2"></div>
    </div>

</main>


<form id="formModifyingDiscipline" method="get" action="/disciplinemodify">
    <input type="hidden" id="idModifyDisc" name="idModifyDisc" value="">
</form>

<form id="formDeleteDiscipline" method="post" action="/disciplines">
    <input type="hidden" id="idsDeleteDisc" name="idsDeleteDisc" value="">
</form>