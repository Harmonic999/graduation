var dataTableApi;
const ajaxUrl = "ajax/restaurants/";

$(function () {
    dataTableApi = $("#datatable").DataTable(
        {
            "ajax":{
                "url": ajaxUrl,
                "dataSrc": ""
            },
            "paging": false,
            "info": true,
            "columns": restaurantListDrawProperties,
            "order": [
                0,
                "asc"
            ],
            "initComplete": makeEditable
        }
    );
});

function save() {
    var form = $("#detailsForm");
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.serialize(),
        success: function () {
            $("#editRow").modal("hide");
            updateTable();
            successNoty("Saved");
        }
    });
}

function updateRow(id) {
    $("#modalTitle").html("Update");
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function updateTable() {
    $.get(ajaxUrl, function (data) {
        dataTableApi.clear().rows.add(data).draw();
    });
}

function redirectToMenu(id) {
    window.location = "restaurants/" + id + "/menu";
}