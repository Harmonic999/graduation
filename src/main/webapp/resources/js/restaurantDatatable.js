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
                    "render": function () {
                        return "Explore Menu"
                    }
                },
                {
                    "defaultContent": "",
                    "orderable": false,
                    "render": renderEditBtn
                },
                {
                    "defaultContent": "",
                    "orderable": false,
                    "render": renderDeleteBtn
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