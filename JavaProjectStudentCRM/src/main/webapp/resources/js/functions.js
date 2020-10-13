function modifySelectDiscipline() {
    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Нужно выбрать дисциплину");
        return;
    }
    if (items.length > 1) {
        alert("Выберите одну дисциплину");
        return;
    }
    var id = $(items[0]).attr("value");
    $('#formModifyingDiscipline input').val(id);
    $('#formModifyingDiscipline').submit();
}

function deleteSelectDisciplines() {
    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Нужно выбрать хотя бы одну дисциплину");
        return;
    }
    var ids;
    for (var i = 0; i < items.length; i++) {
        if (ids == null) {
            ids = "'" + $(items[i]).attr("value") + "'";
        } else {
            ids = ids + ",'" + $(items[i]).attr("value") + "'";
        }
    }
    $('#formDeleteDiscipline input').val(ids);
    $('#formDeleteDiscipline').submit();
}

function showMarksForSelectStudent() {
    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Нужно выбрать студента");
        return;
    }
    if (items.length > 1) {
        alert("Выберите одного студента");
        return;
    }
    var id = $(items[0]).attr("value");
    $('#formMarksStudent input').val(id);
    $('#formMarksStudent').submit();
}

function modifySelectStudent() {
    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Нужно выбрать студента");
        return;
    }
    if (items.length > 1) {
        alert("Выберите одного студента");
        return;
    }
    var id = $(items[0]).attr("value");
    $('#formModifyingStudent input').val(id);
    $('#formModifyingStudent').submit();
}

function deleteSelectStudents() {
    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Нужно выбрать хотя бы одного студента");
        return;
    }
    var ids;
    for (var i = 0; i < items.length; i++) {
        if (ids == null) {
            ids = "'" + $(items[i]).attr("value") + "'";
        } else {
            ids = ids + ",'" + $(items[i]).attr("value") + "'";
        }
    }
    $('#formDeleteStudent input').val(ids);
    $('#formDeleteStudent').submit();
}


function selectTerm() {
    var items = $("option[id=opt1]:selected");
    var id = $(items[0]).attr("value");
    var idStud=$("input[name=idModifyStud]").attr("value");
    $('#idTerm').val(id);
    $('#idSt').val(idStud);
    $('#selectTerm').submit();
}

function selectTermOnTermsList() {
    var id = $("option[id=opt2]:selected").attr("value");
    $('#idTerm').val(id);
    $('#selectTerm').submit();
}

function deleteSelectTerm() {
    var id = $("option[id=opt2]:selected").attr("value");
    $('#idDelTerm').val(id);
    $('#delSelectTerm').submit();
}

function createTermWithSelectedDisciplines() {
    var items = $("option[id=discId]:selected");
    if (items.length == 0) {
        alert("Нужно выбрать дисциплину");
        return;
    }
    var ids;
    for (var i = 0; i < items.length; i++) {
        if (ids == null) {
            ids = $(items[i]).attr("value");
        } else {
            ids = ids + "," + $(items[i]).attr("value");
        }
    }
    $('#idSelectedDisciplines').val(ids);
    $('#formSelectDisciplines').submit();
}

function modifySelectTerm() {
    var id = $("option[id=opt2]:selected").attr("value");
    var discIds =$("input[name=discId]");
    var idsOfDisc;
    for (var i = 0; i < discIds.length; i++) {
        if (idsOfDisc == null) {
            idsOfDisc = $(discIds[i]).attr("value");
        } else {
            idsOfDisc = idsOfDisc + "," + $(discIds[i]).attr("value");
        }
    }
    $('#idsOldDisciplines').val(idsOfDisc);
    $('#idModifyTerm').val(id);
    $('#formModifyingTerm').submit();
}

function rememberOldDisciplines() {
    var items = $("option[id=discId]:selected");
    var ids;
    for (var i = 0; i < items.length; i++) {
        if (ids == null) {
            ids = $(items[i]).attr("value");
        } else {
            ids = ids + "," + $(items[i]).attr("value");
        }
    }
    $('#idOldDisciplines').val(ids);
    $('#modifyTerm').submit();
}
function rememberNewDisciplines() {
    var items = $("option[id=discId]:selected");
    var ids;
    for (var i = 0; i < items.length; i++) {
        if (ids == null) {
            ids = $(items[i]).attr("value");
        } else {
            ids = ids + "," + $(items[i]).attr("value");
        }
    }
    $('#idNewDisciplines').val(ids);
    $('#modifyTerm').submit();
}