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
            "columns": [
                {
                    "data": "name",
                    "render": function (data, type, row) {
                        if (type === "display") {
                            return data;
                        }
                        return data;
                    }
                },
                {
                    "data": "voteCount",
                    "render": function (data, type, row) {
                        if (type === "display") {
                            return data;
                        }
                        return data;
                    }
                },
                {
                    "defaultContent": "",
                    "orderable": false,
                    "render": function (data, type, row) {
                        if (type === "display") {
                            return "<button onclick='redirectToMenu(" + row.id + ")'>Explore Menu</button>";
                        }
                    }
                },
                {
                    "defaultContent": "",
                    "orderable": false,
                    "render": function (data, type, row) {
                        if (type === "display") {
                            return "<a onclick='updateRow(" + row.id + ");'>" +
                                "<span style='color: green; cursor: pointer' class='fa fa-pencil'></span></a>";
                        }
                    }
                },
                {
                    "defaultContent": "",
                    "orderable": false,
                    "render": function (data, type, row) {
                        if (type === "display") {
                            return "<a onclick='deleteRow(" + row.id + ");'>" +
                                "<span style='color: red; cursor: pointer' class='fa fa-remove'></span></a>";
                        }
                    }
                }
            ],
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