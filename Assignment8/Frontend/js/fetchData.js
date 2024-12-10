
var accountHeaderCreateRow = `<!-- Header Row -->
                    <div class="header">
                        <div class="table-header">
                            Ord
                            <div class="sort">
                                <i class="fas fa-caret-up"></i>
                                <i class="fas fa-caret-down"></i>
                            </div>
                        </div>
                        <div class="table-header">
                            ID
                            <div class="sort">
                                <i class="fas fa-caret-up"></i>
                                <i class="fas fa-caret-down"></i>
                            </div>
                        </div>
                        <div class="table-header">
                            Username
                            <div class="sort">
                                <i class="fas fa-caret-up"></i>
                                <i class="fas fa-caret-down"></i>
                            </div>
                        </div>
                        <div class="table-header">
                            Department ID
                            <div class="sort">
                                <i class="fas fa-caret-up"></i>
                                <i class="fas fa-caret-down"></i>
                            </div>
                        </div>
                        <div class="table-header">Actions</div>
                    </div>
            
                    <!-- Table Rows -->

                    <!-- Row 1 -->
                    <div class="row create_row">
                        <div class="table-cell"></div>
                        <div class="table-cell">NextID</div>
                        <div class="table-cell">
                            <input class="create" type="text" name="create_username" id="create_account_username" value="value" maxlength="50">
                        </div>
                        <div class="table-cell">0</div>
                        <div class="table-cell">
                            <div class="create_actions">
                                <i class="fas fa-sd-card"></i>
                                <i class="fas fa-x"></i>
                            </div>
                        </div>
                    </div>`
                
var departmentHeaderCreateRow = `<!-- Header Row -->
                    <div class="header">
                        <div class="table-header">
                            Ord
                            <div class="sort">
                                <i class="fas fa-caret-up"></i>
                                <i class="fas fa-caret-down"></i>
                            </div>
                        </div>
                        <div class="table-header">
                            ID
                            <div class="sort">
                                <i class="fas fa-caret-up"></i>
                                <i class="fas fa-caret-down"></i>
                            </div>
                        </div>
                        <div class="table-header">
                            Name
                            <div class="sort">
                                <i class="fas fa-caret-up"></i>
                                <i class="fas fa-caret-down"></i>
                            </div>
                        </div>
                        <div class="table-header">
                            Total Member
                            <div class="sort">
                                <i class="fas fa-caret-up"></i>
                                <i class="fas fa-caret-down"></i>
                            </div>
                        </div>
                        <div class="table-header">
                            Type
                            <div class="sort">
                                <i class="fas fa-caret-up"></i>
                                <i class="fas fa-caret-down"></i>
                            </div>
                        </div>
                        <div class="table-header">
                            Created Date
                            <div class="sort">
                                <i class="fas fa-caret-up"></i>
                                <i class="fas fa-caret-down"></i>
                            </div>
                        </div>
                        <div class="table-header">Actions</div>
                    </div>
            
                    <!-- Table Rows -->

                    <!-- Row 1 -->
                    <div class="row create_row">
                        <div class="table-cell"></div>
                        <div class="table-cell">NextID</div>
                        <div class="table-cell">
                            <input class="create" type="text" name="create_name" id="create_department_name" value="value" maxlength="50">
                        </div>
                        <div class="table-cell">0</div>
                        <div class="table-cell">
                            <div class="create create_type">
                                <div id="create_type_option">Dev</div>
                                <ul>
                                    <li>Dev</li>
                                    <li>Test</li>
                                    <li>ScrumMaster</li>
                                    <li>PM</li>
                                </ul>
                            </div>
                        </div>
                        <div class="table-cell">Created Date</div>
                        <div class="table-cell">
                            <div class="create_actions">
                                <i class="fas fa-sd-card"></i>
                                <i class="fas fa-x"></i>
                            </div>
                        </div>
                    </div>`


function reset() {
    $("#search").val("");
    $(".option").text("None");
    $(".filter_limit").hide();
    $("#min, #max").attr("type", "number");
    $("#min, #max").val("");
    $(".table-cell").removeClass("table-cell_delete_state");
    $(".save-cancel_state").hide();
    $(".department_table .create_row").hide();
    $(".account_table .create_row").hide();
    fetchDepartmentTable(1);
    fetchAccountTable(1);
}

// == Fetch table account ==
function fetchAccountTable(currentPage) {

    var ord = 0;

    $.ajax({
        url: `http://localhost:8080/api/v1/accounts?pageNumber=${currentPage}&size=7`,
        type: 'GET',
        success: function(response) {

            if (response.content.length !== 0) {

                $(".account_table").empty();
                $(".account_table").append(
                    accountHeaderCreateRow
                )

                response.content.forEach(acc => {
                    const row = 
                        `<div class="row">
                            <div class="table-cell">${ord += 1}</div>
                            <div class="table-cell">${acc.id}</div>
                            <div class="table-cell">
                                <div class="official_info info_username">${acc.username}</div>
                                <input class="edit" type="text" name="edit_username" id="edit_account_username">
                            </div>
                            <div class="table-cell">
                                <div class="official_info info_a_d_name">${acc.departmentName}</div>
                                <input class="edit" type="text" name="edit_d_name" id="edit_account_department_name">
                            </div>
                            <div class="table-cell">
                                <div class="actions">
                                    <i class="fas fa-pen"></i>
                                    <i class="fas fa-delete-left"></i>
                                    <i class="fas fa-check"></i>
                                    <i class="fas fa-xmark"></i>
                                </div>
                            </div>
                        </div>`
                    $(".account_table").append(row);
                });
                
                $(".fa-check").hide();
                $(".fa-xmark").hide();
                $(".edit").hide();
                
                createRow();
                
                updatePage((response.pageable.pageNumber + 1), response.totalPages);
            } else {
                alert("red", "Database Empty !");
            }
                
        }
    })

}

// == Fetch table department ==
function fetchDepartmentTable(currentPage) {

    var ord = 0;

    $.ajax({
        url: `http://localhost:8080/api/v1/departments?pageNumber=${currentPage}&size=7`,
        type: 'GET',
        success: function(response) {

            if (response.content.length !== 0) {

                $(".department_table").empty();

                $(".department_table").append(
                    departmentHeaderCreateRow
                );

                response.content.forEach(dep => {
                    const row = 
                        `<div class="row">
                            <div class="table-cell">${ord += 1}</div>
                            <div class="table-cell">${dep.id}</div>
                            <div class="table-cell">
                                <div class="official_info info_name">${dep.name}</div>
                                <input class="edit" type="text" name="edit_name" id="edit_department_name" value="old value" maxlength="50">
                            </div>
                            <div class="table-cell">${dep.totalMember}</div>
                            <div class="table-cell">
                                <div class="official_info info_type">${dep.type}</div>
                                <div class="edit edit_type">
                                    <div id="edit_type_option">DEV</div>
                                    <ul>
                                        <li>Dev</li>
                                        <li>Test</li>
                                        <li>ScrumMaster</li>
                                        <li>PM</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="table-cell">${dep.createdDate}</div>
                            <div class="table-cell">
                                <div class="actions">
                                    <i class="fas fa-pen"></i>
                                    <i class="fas fa-delete-left"></i>
                                    <i class="fas fa-check"></i>
                                    <i class="fas fa-xmark"></i>
                                </div>
                            </div>
                        </div>`

                    $(".department_table").append(row);
                });
                
                $(".fa-check").hide();
                $(".fa-xmark").hide();
                $(".edit").hide();

                createRow();

                updatePage((response.pageable.pageNumber + 1), response.totalPages);
            } else {
                alert("red", "Database Empty !");
            }

        }
    })

}

function createRow() {
    $(".department_table .create_row").hide();
    $(".account_table .create_row").hide();

    $(".act__create").click(function() {
        $(".department_table .create_row").fadeIn("fast");
        $(".account_table .create_row").fadeIn("fast");
    });

    $(".fa-x").click(function() {
        $(".department_table .create_row").fadeOut("fast");
        $(".account_table .create_row").fadeOut("fast");
    });

    $(".create_actions .fa-check, .create_actions .fa-xmark").show();
    $(".table-cell .create_type ul").fadeOut();

    // Show the dropdown and hide the option button on click
    $(document).on("click", ".row #create_type_option", function (e) {
        e.stopPropagation();
        var row = $(this).closest(".row");
        
        row.find(".table-cell .create_type ul").fadeIn();
    });

    // Prevent dropdown closing when clicking inside
    $(document).on("click", ".table-cell .create_type ul", function (e) {
        e.stopPropagation();
    });

    // Handle selection from the dropdown
    $(document).on("click", ".table-cell .create_type ul li", function () {
        var row = $(this).closest(".row"); 
        var selectedValue = $(this).text(); 
        row.find("#create_type_option").text(selectedValue); 
        row.find(".table-cell .create_type ul").fadeOut(); 
    });

    // Handle click anywhere else on the document to close the dropdown
    $(document).click(function () {
        $(".table-cell .create_type ul").fadeOut();
    });
}

function updatePage(first_page, last_page) {
    $("#first_page").text(first_page);
    $("#last_page").text(last_page);

    if (first_page == 1) {
        $("#prev").addClass("pages_inactive");
    } else {
        $("#prev").removeClass("pages_inactive");
    }
    
    if (first_page === last_page) {
        $("#next").addClass("pages_inactive");
    } else {
        $("#next").removeClass("pages_inactive");
    }
}

function alert(color, notify) {
    $(".notify").css({
        "background-image": "linear-gradient(to bottom, white," + color + ", white)",
        "box-shadow": "1px 1px 10px " + color,
    });

    $(".notify").text(notify);
    $(".notify").addClass("notify_show");

    setTimeout(function() {
        $(".notify").removeClass("notify_show");
        $(".notify").addClass("notify_lowhide");

        setTimeout(function() {
            $(".notify").removeClass("notify_lowhide");
            $(".notify").addClass("notify_midhide");
            
            setTimeout(function() {
                $(".notify").removeClass("notify_midhide");
                $(".notify").addClass("notify_hide");

                setTimeout(function() {
                    $(".notify").removeClass("notify_hide");
                }, 25);

            }, 50);

        }, 75);

    }, 2000);


}

function searchAccByDepNameAndUsername(query) {
    
    var ord = 0;
    
    if (query) {
        $.ajax({
            url: `http://localhost:8080/api/v1/accounts?search=${query}`,
            type: 'GET',
            success: function(response) {
    
                if (response.content.length !== 0) {
    
                    $(".account_table").empty();
                    $(".account_table").append(
                        accountHeaderCreateRow
                    )
    
                    response.content.forEach(acc => {
                        const row = 
                            `<div class="row">
                                <div class="table-cell">${ord += 1}</div>
                                <div class="table-cell">${acc.id}</div>
                                <div class="table-cell">
                                    <div class="official_info info_username">${acc.username}</div>
                                    <input class="edit" type="text" name="edit_username" id="edit_account_username">
                                </div>
                                <div class="table-cell">
                                    <div class="official_info info_a_d_name">${acc.departmentName}</div>
                                    <input class="edit" type="text" name="edit_d_name" id="edit_account_department_name">
                                </div>
                                <div class="table-cell">
                                    <div class="actions">
                                        <i class="fas fa-pen"></i>
                                        <i class="fas fa-delete-left"></i>
                                        <i class="fas fa-check"></i>
                                        <i class="fas fa-xmark"></i>
                                    </div>
                                </div>
                            </div>`
                        $(".account_table").append(row);
                    });
                    
                    $(".fa-check").hide();
                    $(".fa-xmark").hide();
                    $(".edit").hide();
                    
                    createRow();
                    
                    updatePage((response.pageable.pageNumber + 1), response.totalPages);
                } else {
                    alert("darkolivegreen", "No search result !");
                    fetchAccountTable(1);
                }
            }
        })
    } else {
        alert("darkblue", "Enter search term !");
        fetchAccountTable(1);
    }
}

function searchDepByName(query) {

    var ord = 0;

    if (query) {
        $.ajax({
            url: `http://localhost:8080/api/v1/departments?search=${query}`,
            type: 'GET',
            success: function(response) {
    
                if (response.content.length !== 0) {
    
                    $(".department_table").empty();

                    $(".department_table").append(
                        departmentHeaderCreateRow
                    );

                    response.content.forEach(dep => {
                        const row = 
                            `<div class="row">
                                <div class="table-cell">${ord += 1}</div>
                                <div class="table-cell">${dep.id}</div>
                                <div class="table-cell">
                                    <div class="official_info info_name">${dep.name}</div>
                                    <input class="edit" type="text" name="edit_name" id="edit_department_name" value="old value" maxlength="50">
                                </div>
                                <div class="table-cell">${dep.totalMember}</div>
                                <div class="table-cell">
                                    <div class="official_info info_type">${dep.type}</div>
                                    <div class="edit edit_type">
                                        <div id="edit_type_option">DEV</div>
                                        <ul>
                                            <li>Dev</li>
                                            <li>Test</li>
                                            <li>ScrumMaster</li>
                                            <li>PM</li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="table-cell">${dep.createdDate}</div>
                                <div class="table-cell">
                                    <div class="actions">
                                        <i class="fas fa-pen"></i>
                                        <i class="fas fa-delete-left"></i>
                                        <i class="fas fa-check"></i>
                                        <i class="fas fa-xmark"></i>
                                    </div>
                                </div>
                            </div>`

                        $(".department_table").append(row);
                    });
                    
                    $(".fa-check").hide();
                    $(".fa-xmark").hide();
                    $(".edit").hide();

                    createRow();

                    updatePage((response.pageable.pageNumber + 1), response.totalPages);
                } else {
                    alert("darkolivegreen", "No search result !");
                    fetchDepartmentTable(1);
                }
            }
        })
    } else {
        alert("darkblue", "Enter search term !");
    }
}

function filterAccountByDepartmentType(type, currentPage) {

    var ord = 0;

    $.ajax({
        url: `http://localhost:8080/api/v1/accounts?type=${type}&pageNumber=${currentPage}&size=7`,
        type: 'GET',
        success: function(response) {

            if (response.content.length !== 0) {
                $(".account_table").empty();
                $(".account_table").append(
                    accountHeaderCreateRow
                )

                response.content.forEach(acc => {
                    const row = 
                        `<div class="row">
                            <div class="table-cell">${ord += 1}</div>
                            <div class="table-cell">${acc.id}</div>
                            <div class="table-cell">
                                <div class="official_info info_username">${acc.username}</div>
                                <input class="edit" type="text" name="edit_username" id="edit_account_username">
                            </div>
                            <div class="table-cell">
                                <div class="official_info info_a_d_name">${acc.departmentName}</div>
                                <input class="edit" type="text" name="edit_d_name" id="edit_account_department_name">
                            </div>
                            <div class="table-cell">
                                <div class="actions">
                                    <i class="fas fa-pen"></i>
                                    <i class="fas fa-delete-left"></i>
                                    <i class="fas fa-check"></i>
                                    <i class="fas fa-xmark"></i>
                                </div>
                            </div>
                        </div>`
                    $(".account_table").append(row);
                });
                
                $(".fa-check").hide();
                $(".fa-xmark").hide();
                $(".edit").hide();
                
                createRow();
                
                updatePage((response.pageable.pageNumber + 1), response.totalPages);
           } else {
                alert("darkmagenta", "No data for this type !");

                fetchAccountTable(1);
           }
        }
    })
}

function filterDepartmentByType(type, currentPage) {

    var ord = 0;

    $.ajax({
        url: `http://localhost:8080/api/v1/departments?type=${type}&pageNumber=${currentPage}&size=7`,
        type: 'GET',
        success: function(response) {

            if (response.content.length !== 0) {
                $(".department_table").empty();

                $(".department_table").append(
                    departmentHeaderCreateRow
                );

                response.content.forEach(dep => {
                    const row = 
                        `<div class="row">
                            <div class="table-cell">${ord += 1}</div>
                            <div class="table-cell">${dep.id}</div>
                            <div class="table-cell">
                                <div class="official_info info_name">${dep.name}</div>
                                <input class="edit" type="text" name="edit_name" id="edit_department_name" value="old value" maxlength="50">
                            </div>
                            <div class="table-cell">${dep.totalMember}</div>
                            <div class="table-cell">
                                <div class="official_info info_type">${dep.type}</div>
                                <div class="edit edit_type">
                                    <div id="edit_type_option">DEV</div>
                                    <ul>
                                        <li>Dev</li>
                                        <li>Test</li>
                                        <li>ScrumMaster</li>
                                        <li>PM</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="table-cell">${dep.createdDate}</div>
                            <div class="table-cell">
                                <div class="actions">
                                    <i class="fas fa-pen"></i>
                                    <i class="fas fa-delete-left"></i>
                                    <i class="fas fa-check"></i>
                                    <i class="fas fa-xmark"></i>
                                </div>
                            </div>
                        </div>`

                    $(".department_table").append(row);
                });
                
                $(".fa-check").hide();
                $(".fa-xmark").hide();
                $(".edit").hide();

                createRow();

                updatePage((response.pageable.pageNumber + 1), response.totalPages);

            } else {
                alert("darkmagenta", "No data for filtering !");

                fetchDepartmentTable(1);
            }
        }
    })
}

function filterDepartmentByID(minId, maxId, currentPage) {
    var ord = 0;
    var query = "";

    // Use proper string interpolation by wrapping the string in backticks.
    if (minId) {
        query = `minId=${minId}`; 

        if (maxId) {
            query += `&maxId=${maxId}`; 
        }
    } else if (maxId) {
        query = `maxId=${maxId}`; 
    } else {
        fetchDepartmentTable(1);
        return;
    }

    
    $.ajax({
        url: `http://localhost:8080/api/v1/departments?${query}&pageNumber=${currentPage}&size=7`, // Use the correct URL string
        type: 'GET',
        success: function(response) {
            if (response.content.length !== 0) {
                $(".department_table").empty();

                $(".department_table").append(departmentHeaderCreateRow);

                response.content.forEach(dep => {
                    const row =
                        `<div class="row">
                            <div class="table-cell">${ord += 1}</div>
                            <div class="table-cell">${dep.id}</div>
                            <div class="table-cell">
                                <div class="official_info info_name">${dep.name}</div>
                                <input class="edit" type="text" name="edit_name" id="edit_department_name" value="old value" maxlength="50">
                            </div>
                            <div class="table-cell">${dep.totalMember}</div>
                            <div class="table-cell">
                                <div class="official_info info_type">${dep.type}</div>
                                <div class="edit edit_type">
                                    <div id="edit_type_option">DEV</div>
                                    <ul>
                                        <li>Dev</li>
                                        <li>Test</li>
                                        <li>ScrumMaster</li>
                                        <li>PM</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="table-cell">${dep.createdDate}</div>
                            <div class="table-cell">
                                <div class="actions">
                                    <i class="fas fa-pen"></i>
                                    <i class="fas fa-delete-left"></i>
                                    <i class="fas fa-check"></i>
                                    <i class="fas fa-xmark"></i>
                                </div>
                            </div>
                        </div>`;

                    $(".department_table").append(row);
                });

                $(".fa-check").hide();
                $(".fa-xmark").hide();
                $(".edit").hide();

                createRow();

                updatePage((response.pageable.pageNumber + 1), response.totalPages);

            } 
        }
    })
}

function filterDepartmentByTotalMember(minTotalMember, maxTotalMember, currentPage) {
    var ord = 0;
    var query = "";

    // Use proper string interpolation by wrapping the string in backticks.
    if (minTotalMember) {
        query = `minTotalMember=${minTotalMember}`; 

        if (maxTotalMember) {
            query += `&maxTotalMember=${maxTotalMember}`; 
        }
    } else if (maxTotalMember) {
        query = `maxId=${maxTotalMember}`; 
    } else {
        fetchDepartmentTable(1);
        return;
    }

    
    $.ajax({
        url: `http://localhost:8080/api/v1/departments?${query}&pageNumber=${currentPage}&size=7`, // Use the correct URL string
        type: 'GET',
        success: function(response) {
            if (response.content.length !== 0) {
                $(".department_table").empty();

                $(".department_table").append(departmentHeaderCreateRow);

                response.content.forEach(dep => {
                    const row =
                        `<div class="row">
                            <div class="table-cell">${ord += 1}</div>
                            <div class="table-cell">${dep.id}</div>
                            <div class="table-cell">
                                <div class="official_info info_name">${dep.name}</div>
                                <input class="edit" type="text" name="edit_name" id="edit_department_name" value="old value" maxlength="50">
                            </div>
                            <div class="table-cell">${dep.totalMember}</div>
                            <div class="table-cell">
                                <div class="official_info info_type">${dep.type}</div>
                                <div class="edit edit_type">
                                    <div id="edit_type_option">DEV</div>
                                    <ul>
                                        <li>Dev</li>
                                        <li>Test</li>
                                        <li>ScrumMaster</li>
                                        <li>PM</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="table-cell">${dep.createdDate}</div>
                            <div class="table-cell">
                                <div class="actions">
                                    <i class="fas fa-pen"></i>
                                    <i class="fas fa-delete-left"></i>
                                    <i class="fas fa-check"></i>
                                    <i class="fas fa-xmark"></i>
                                </div>
                            </div>
                        </div>`;

                    $(".department_table").append(row);
                });

                $(".fa-check").hide();
                $(".fa-xmark").hide();
                $(".edit").hide();

                createRow();

                updatePage((response.pageable.pageNumber + 1), response.totalPages);

            } 
        }
    })
}

function formatDate(inputDate) {
    const date = new Date(inputDate);
    const day = String(date.getDate()).padStart(2, '0'); 
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = date.getFullYear(); 

    return `${day}-${month}-${year}`; 
}

function filterDepartmentByCreatedDate(minCreatedDate, maxCreatedDate, currentPage) {
    var ord = 0;
    var query = "";

    // Use proper string interpolation by wrapping the string in backticks.
    if (minCreatedDate) {
        query = `minCreatedDate=${minCreatedDate}`; 

        if (maxCreatedDate) {
            query += `&maxCreatedDate=${maxCreatedDate}`; 
        }
    } else if (maxCreatedDate) {
        query = `maxId=${maxCreatedDate}`; 
    } else {
        fetchDepartmentTable(1);
        return;
    }

    
    $.ajax({
        url: `http://localhost:8080/api/v1/departments?${query}&pageNumber=${currentPage}&size=7`, // Use the correct URL string
        type: 'GET',
        success: function(response) {
            if (response.content.length !== 0) {
                $(".department_table").empty();

                $(".department_table").append(departmentHeaderCreateRow);

                response.content.forEach(dep => {
                    const row =
                        `<div class="row">
                            <div class="table-cell">${ord += 1}</div>
                            <div class="table-cell">${dep.id}</div>
                            <div class="table-cell">
                                <div class="official_info info_name">${dep.name}</div>
                                <input class="edit" type="text" name="edit_name" id="edit_department_name" value="old value" maxlength="50">
                            </div>
                            <div class="table-cell">${dep.totalMember}</div>
                            <div class="table-cell">
                                <div class="official_info info_type">${dep.type}</div>
                                <div class="edit edit_type">
                                    <div id="edit_type_option">DEV</div>
                                    <ul>
                                        <li>Dev</li>
                                        <li>Test</li>
                                        <li>ScrumMaster</li>
                                        <li>PM</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="table-cell">${dep.createdDate}</div>
                            <div class="table-cell">
                                <div class="actions">
                                    <i class="fas fa-pen"></i>
                                    <i class="fas fa-delete-left"></i>
                                    <i class="fas fa-check"></i>
                                    <i class="fas fa-xmark"></i>
                                </div>
                            </div>
                        </div>`;

                    $(".department_table").append(row);
                });

                $(".fa-check").hide();
                $(".fa-xmark").hide();
                $(".edit").hide();

                createRow();

                updatePage((response.pageable.pageNumber + 1), response.totalPages);

            }
        }
    })
}

function filterDepartmentByYear(minYear, maxYear, currentPage) {
    var ord = 0;
    var query = "";

    // Use proper string interpolation by wrapping the string in backticks.
    if (minYear) {
        query = `minYear=${minYear}`; 

        if (maxYear) {
            query += `&maxYear=${maxYear}`; 
        }
    } else if (maxYear) {
        query = `maxYear=${maxYear}`; 
    } else {
        fetchDepartmentTable(1);
        return;
    }

    
    $.ajax({
        url: `http://localhost:8080/api/v1/departments?${query}&pageNumber=${currentPage}&size=7`, // Use the correct URL string
        type: 'GET',
        success: function(response) {
            if (response.content.length !== 0) {
                $(".department_table").empty();

                $(".department_table").append(departmentHeaderCreateRow);

                response.content.forEach(dep => {
                    const row =
                        `<div class="row">
                            <div class="table-cell">${ord += 1}</div>
                            <div class="table-cell">${dep.id}</div>
                            <div class="table-cell">
                                <div class="official_info info_name">${dep.name}</div>
                                <input class="edit" type="text" name="edit_name" id="edit_department_name" value="old value" maxlength="50">
                            </div>
                            <div class="table-cell">${dep.totalMember}</div>
                            <div class="table-cell">
                                <div class="official_info info_type">${dep.type}</div>
                                <div class="edit edit_type">
                                    <div id="edit_type_option">DEV</div>
                                    <ul>
                                        <li>Dev</li>
                                        <li>Test</li>
                                        <li>ScrumMaster</li>
                                        <li>PM</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="table-cell">${dep.createdDate}</div>
                            <div class="table-cell">
                                <div class="actions">
                                    <i class="fas fa-pen"></i>
                                    <i class="fas fa-delete-left"></i>
                                    <i class="fas fa-check"></i>
                                    <i class="fas fa-xmark"></i>
                                </div>
                            </div>
                        </div>`;

                    $(".department_table").append(row);
                });

                $(".fa-check").hide();
                $(".fa-xmark").hide();
                $(".edit").hide();

                createRow();

                updatePage((response.pageable.pageNumber + 1), response.totalPages);

            }
        }
    })
}

function filterDepartmentByAccountQuantity(minAccountQuantity, maxAccountQuantity, currentPage) {
    var ord = 0;
    var query = "";

    // Use proper string interpolation by wrapping the string in backticks.
    if (minAccountQuantity) {
        query = `minAccountQuantity=${minAccountQuantity}`; 

        if (maxAccountQuantity) {
            query += `&maxAccountQuantity=${maxAccountQuantity}`; 
        }
    } else if (maxAccountQuantity) {
        query = `maxAccountQuantity=${maxAccountQuantity}`; 
    } else {
        fetchDepartmentTable(1);
        return;
    }

    
    $.ajax({
        url: `http://localhost:8080/api/v1/departments?${query}&pageNumber=${currentPage}&size=7`, // Use the correct URL string
        type: 'GET',
        success: function(response) {
            if (response.content.length !== 0) {
                $(".department_table").empty();

                $(".department_table").append(departmentHeaderCreateRow);

                response.content.forEach(dep => {
                    const row =
                        `<div class="row">
                            <div class="table-cell">${ord += 1}</div>
                            <div class="table-cell">${dep.id}</div>
                            <div class="table-cell">
                                <div class="official_info info_name">${dep.name}</div>
                                <input class="edit" type="text" name="edit_name" id="edit_department_name" value="old value" maxlength="50">
                            </div>
                            <div class="table-cell">${dep.totalMember}</div>
                            <div class="table-cell">
                                <div class="official_info info_type">${dep.type}</div>
                                <div class="edit edit_type">
                                    <div id="edit_type_option">DEV</div>
                                    <ul>
                                        <li>Dev</li>
                                        <li>Test</li>
                                        <li>ScrumMaster</li>
                                        <li>PM</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="table-cell">${dep.createdDate}</div>
                            <div class="table-cell">
                                <div class="actions">
                                    <i class="fas fa-pen"></i>
                                    <i class="fas fa-delete-left"></i>
                                    <i class="fas fa-check"></i>
                                    <i class="fas fa-xmark"></i>
                                </div>
                            </div>
                        </div>`;

                    $(".department_table").append(row);
                });

                $(".fa-check").hide();
                $(".fa-xmark").hide();
                $(".edit").hide();

                createRow();

                updatePage((response.pageable.pageNumber + 1), response.totalPages);

            }
        }
    })
}


