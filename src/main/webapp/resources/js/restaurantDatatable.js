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

function updateRow(id) {
    $("#modalTitle").html("Update");
    $.get(ajaxUrl + id.replaceAll(".", "/"), function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function redirectToMenu(id) {
    window.location = "restaurants/" + id + "/menu";
}