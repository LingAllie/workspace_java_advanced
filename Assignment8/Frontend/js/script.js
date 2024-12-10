$(document).ready(function() {

    var currentPageDep = 1;
    var currentPageAcc = 1;
    var currentPageDepFilter = 1;
    var currentPageAccFilter = 1;
    var option = "None";
    
    // == Sidebar ==
    $(".sidebar__item1").addClass("sidebar_active");
    fetchDepartmentTable(currentPageDep);

    $(".sidebar__item1").click(function() {
        currentPageDep = 1;
        $(".sidebar__item1").addClass("sidebar_active");
        $(".sidebar__item2").removeClass("sidebar_active");

        $(".filter_option > li").each(function(idx, e) {
            $(e).show();
        });
        $(".filter_type").removeClass("li_none");

        reset();
    });
   
    $(".sidebar__item2").click(function() {
        currentPageAcc = 1;
        $(".sidebar__item2").addClass("sidebar_active");
        $(".sidebar__item1").removeClass("sidebar_active");

        $(".filter_option > li").each(function(idx, e) {
            if (idx != 5) {
                $(e).hide();
            }
        });
        $(".filter_type").addClass("li_none");

        reset();
    });

    // == Search ==
    // $("#search").on('keydown', function(event) {
    //     if (event.keyCode === 13) {
    //         event.preventDefault();

    //         var query = $(this).val().trim();

    //         if ($(".sidebar__item1").hasClass("sidebar_active")) {
    //             searchDepByName(query);
    //         }

    //         if ($(".sidebar__item2").hasClass("sidebar_active")) {
    //             searchAccByDepNameAndUsername(query);
    //         }
    //     }
    // });

    // $(".fa-magnifying-glass").click(function() {
    //     var query = $("#search").val().trim();

    //     if ($(".sidebar__item1").hasClass("sidebar_active")) {
    //         searchDepByName(query);
    //     }
        
    //     if ($(".sidebar__item2").hasClass("sidebar_active")) {
    //         searchAccByDepNameAndUsername(query);
    //     }
    // });

    $("#search").on('input', function() {
        const query = $(this).val().trim();

        if (query) {
            if ($(".sidebar__item1").hasClass("sidebar_active")) {
                searchDepByName(query);
            }
            
            if ($(".sidebar__item2").hasClass("sidebar_active")) {
                searchAccByDepNameAndUsername(query);
            }
        } else {
            if ($(".sidebar__item1").hasClass("sidebar_active")) {
                fetchDepartmentTable(1);
            }
            
            if ($(".sidebar__item2").hasClass("sidebar_active")) {
                fetchAccountTable(1);
            }
        }
    });


    // == Filter ==
    if ($(".option").text().trim() === "None") {
        $(".filter_limit").hide();
    } 

    $(".fa-filter").click(function (event) {
        event.stopPropagation(); 
        $(".filter_option").fadeToggle("fast", function () {
            $(this).toggleClass("filter_active");
        });
    });
    
    $(document).click(function () {
        $(".filter_option").fadeOut("fast", function () {
            $(this).removeClass("filter_active");
        });
    });

    $(".filter_type").css("display", "none");

    $("#option6").hover(
        function () {
            $(".filter_type").css("display", "block");
            $("#option1, #option2, #option3, #option4, #option5").addClass("filter_inactive");
        },
        function () {
            if ($(".filter_type").css("display") !== "block") {
                $("#option1, #option2, #option3, #option4, #option5").removeClass("filter_inactive");
            } else {
                $(".filter_type").css('display', 'none');
                $("#option1, #option2, #option3, #option4, #option5").removeClass("filter_inactive");
            }
        }
    );

    var cout = 1;
    
    $(".filter_option > li").on('click', function () {

        var clickedText = $(this).text().trim(); 
        option = clickedText;

        if (clickedText.includes("Type")) {
            console.log("type " + cout);
            cout++;
            $(".filter_limit").hide();
            filter_type();

        } else if (clickedText === "Created Date") {
            fetchDepartmentTable(currentPageDep);
            $("#min, #max").attr("type", "date");
            $(".option").text(clickedText); 

        } else {
            fetchDepartmentTable(currentPageDep);
            $("#min, #max").attr("type", "number");
            $(".filter_limit").show();
            $(".option").text(clickedText); 
        }
    });

    var typeText = "";

    function filter_type() {
        $(document).on('click', '.filter_type > li', function() { 

            typeText = $(this).text().trim();
    
            if (typeText !== "") {
                console.log("type " + typeText);
                $(".option").text("Type: " + typeText );
                
                if ($(".sidebar__item1").hasClass("sidebar_active")) {
                    filterDepartmentByType(typeText.toUpperCase(), currentPageDepFilter);
                }
                if ($(".sidebar__item2").hasClass("sidebar_active")) {
                    filterAccountByDepartmentType(typeText.toUpperCase(), currentPageAccFilter);
                }
            } else {
                $(".option").text("None");
            }
        });
    }
    
    var minValue = null;
    var maxValue = null;

    $("#min, #max").on('input', function() {
        // Get the values of #min and #max
        minValue = $("#min").val();
        maxValue = $("#max").val();

        // Check if the .option text includes "ID"
        if ($(".option").text().trim().includes("ID")) {
            filterDepartmentByID(minValue, maxValue, currentPageDepFilter);
        }

        if ($(".option").text().trim().includes("Member")) {
            filterDepartmentByTotalMember(minValue, maxValue, currentPageDepFilter);
        }

        if ($(".option").text().trim().includes("Created")) {

            formatDate(minValue);
            formatDate(maxValue);

            filterDepartmentByCreatedDate(minValue, maxValue, currentPageDepFilter);
        }

        if ($(".option").text().trim().includes("Year")) {
            if ((minValue && minValue >= 1000) || (maxValue && maxValue >= 1000)) {
                filterDepartmentByYear(minValue, maxValue, currentPageDepFilter);
            } else {
                fetchDepartmentTable(1);
            }
        }

        if ($(".option").text().trim().includes("Quantity")) {
            filterDepartmentByAccountQuantity(minValue, maxValue, currentPageDepFilter);
        }
    });
    

    // == Table ==
    $(".account_table").hide();

    $(".sidebar__item1").click(function() {
        $(".department_table").fadeIn("fast");
        $(".account_table").fadeOut("fast");
    });

    $(".sidebar__item2").click(function() {
        $(".department_table").fadeOut("fast");
        $(".account_table").fadeIn("fast");
    });



    // == Edit row ==

    var isEditing = false; 

    // Initially hide the checkmark, edit fields, and dropdown
    $(".fa-check").hide();
    $(".fa-xmark").hide();
    $(".edit").hide();
    $(".table-cell .edit_type ul").fadeOut();

    // Show the dropdown and hide the option button on click
    $(document).on("click", ".row #edit_type_option", function (e) {
        e.stopPropagation();
        var row = $(this).closest(".row");
        
        row.find(".table-cell .edit_type ul").fadeIn();
    });

    // Prevent dropdown closing when clicking inside
    $(document).on("click", ".table-cell .edit_type ul", function (e) {
        e.stopPropagation();
    });

    // Handle selection from the dropdown
    $(document).on("click", ".table-cell .edit_type ul li", function () {
        var row = $(this).closest(".row"); 
        var selectedValue = $(this).text(); 
        row.find("#edit_type_option").text(selectedValue); 
        row.find(".table-cell .edit_type ul").fadeOut(); 
    });

    // Handle click anywhere else on the document to close the dropdown
    $(document).click(function () {
        if (isEditing) {
            $(".table-cell .edit_type ul").fadeOut();
        } 
    });

    var oldDepartmentName = "";
    var oldDepartmentType = "";
    var oldUsername = "";
    var oldAccDepName = "";

    // Handle the edit button click
    $(document).on("click", ".fa-pen", function () {

        if (isEditing) {
            $(".notify").css({
                "background-image": "linear-gradient(to bottom, white, red, white)",
                "box-shadow": "1px 1px 10px red",
            });

            $(".notify").text("Complete current edit !");
            $(".notify").addClass("notify_show");
        
            setTimeout(function() {
                $(".notify").removeClass("notify_show");
            }, 3000); 

            return;
        }
        

        var row = $(this).closest(".row"); 
        var official_info_name = row.find(".info_name").text();
        var official_info_type = row.find(".info_type").text();
        var official_info_username = row.find(".info_username").text();
        var official_info_a_d_name = row.find(".info_a_d_name").text();

        oldDepartmentName = official_info_name;
        oldDepartmentType = official_info_type;
        oldUsername = official_info_username;
        oldAccDepName = official_info_a_d_name;

        row.find("#edit_department_name").val(official_info_name);
        row.find("#edit_type_option").text(official_info_type);
        row.find("#edit_account_username").val(official_info_username);
        row.find("#edit_account_department_name").val(official_info_a_d_name);

        // Hide official info and show editable fields concurrently
        row.find(".official_info").fadeOut("fast");
        row.find(".fa-pen").fadeOut("fast");
        row.find(".edit").fadeIn("fast");
        row.find(".fa-check").fadeIn("fast");
        row.find(".fa-xmark").fadeIn("fast");
        row.find(".fa-delete-left").fadeOut("fast");

         // Set the current row to the edited row and mark it as editing
        isEditing = true;
        currentRow = row;
    });

    // Handle the checkmark button click
    $(document).on("click", ".fa-check", function () {
        var row = $(this).closest(".row"); 

        var departmentName = row.find("#edit_department_name").val();        
        row.find(".info_name").text(departmentName);  
        
        var selectedEditType = row.find("#edit_type_option").text();
        row.find(".info_type").text(selectedEditType); 
        
        var accountUsername = row.find("#edit_account_username").val();        
        row.find(".info_username").text(accountUsername);  
        
        var editAccDepName = row.find("#edit_account_department_id").val();
        row.find(".info_a_d_name").text(editAccDepName); 

        // Hide editable fields and show official info concurrently
        row.find(".edit").fadeOut("fast");
        row.find(".fa-check").fadeOut("fast");
        row.find(".fa-pen").fadeIn("fast");
        row.find(".official_info").fadeIn("fast");
        row.find(".fa-xmark").fadeOut("fast");
        row.find(".fa-delete-left").fadeIn("fast");

        // Mark that editing is done and allow editing other rows
        isEditing = false;
        currentRow = null;
    });

    $(document).on("click", ".fa-xmark", function () {
        var row = $(this).closest(".row"); 

        row.find(".info_name").text(oldDepartmentName);  
        row.find(".info_type").text(oldDepartmentType); 
        row.find(".info_username").text(oldUsername);
        row.find(".info_a_d_name").text(oldAccDepName);


        // Hide editable fields and show official info concurrently
        row.find(".edit").fadeOut("fast");
        row.find(".fa-check").fadeOut("fast");
        row.find(".fa-pen").fadeIn("fast");
        row.find(".official_info").fadeIn("fast");
        row.find(".fa-xmark").fadeOut("fast");
        row.find(".fa-delete-left").fadeIn("fast");

        // Mark that editing is done and allow editing other rows
        isEditing = false;
        currentRow = null;
    });


    // == Delete row ==
    $(".save-cancel_state").hide();

    $(document).on("click", ".fa-delete-left", function() {
        var row = $(this).closest(".row");

        row.find(".table-cell").toggleClass("table-cell_delete_state");

        updateSaveCancelState();        
    })

    // Function to check the state and show/hide the save/cancel state
    function updateSaveCancelState() {
        // Check if any row has the 'table-cell_delete_state' class
        if ($(".table-cell_delete_state").length > 0) {
            $(".save-cancel_state").show();  
        } else {
            $(".save-cancel_state").hide(); 
        }
    }

    $("#cancel_table_state").click(function() {
        $(".table-cell").removeClass("table-cell_delete_state");
    
        $(".save-cancel_state").hide();
    });
    
    $(".act__delete").click(function() {
        $(".table-cell").addClass("table-cell_delete_state");
        updateSaveCancelState();
    })


    // == Reset ==

    $(".act__reset").click(function() {
        // reset();
        // option = "None";
        location.reload();
    })

    
    // == Pages ==
    

    var prev = $("#prev");
    var next = $("#next");

    if ((currentPageAcc == 1 && currentPageDep == 1) || (currentPageAccFilter == 1 && currentPageDepFilter == 1)) {
        $("#prev").addClass("pages_inactive");
    } else {
        $("#prev").removeClass("pages_inactive");
    }

    // Handle previous button click with animation
    prev.click(function () {
        if ($(".sidebar__item1").hasClass("sidebar_active")) {
            if (currentPageDep > 1) {
                currentPageDep--;

                $(".department_table").fadeOut(300, function () {
                    if (option === "None") {
                        fetchDepartmentTable(currentPageDep); 
                    } else {
                        if (currentPageDepFilter > 1) {
                            currentPageDepFilter--;
                            if (option.includes("Type")) {
                                filterDepartmentByType(typeText.toUpperCase(), currentPageDepFilter);
                            } else if (option.includes("ID")) {
                                filterDepartmentByID(minValue, maxValue, currentPageDepFilter);
                            } else if (option.includes("Member")) {
                                filterDepartmentByTotalMember(minValue, maxValue, currentPageDepFilter);
                            } else if (option.includes("Date")) {
                                filterDepartmentByCreatedDate(minValue, maxValue, currentPageDepFilter);
                            } else if (option.includes("Year")) {
                                filterDepartmentByYear(minValue, maxValue, currentPageDepFilter);
                            } else if (option.includes("Quantity")) {
                                filterDepartmentByAccountQuantity(minValue, maxValue, currentPageDepFilter);
                            }
                        }
                    }
                    $(".department_table").fadeIn(300); 
                });
            } else {
                fetchDepartmentTable(1); 
            }
        }

        if ($(".sidebar__item2").hasClass("sidebar_active")) {
            if (currentPageAcc > 1) {
                currentPageAcc--;

                $(".account_table").fadeOut(300, function () {
                    if (option === "None") {
                        fetchAccountTable(currentPageAcc); 
                    } else {
                        if (currentPageAccFilter > 1) {
                            currentPageAccFilter--;
                            if (option.includes("Type")) {
                                filterAccountByDepartmentType(typeText.toUpperCase(), currentPageAccFilter);
                            }
                        }
                    }
                    $(".account_table").fadeIn(300); 
                });
            } else {
                fetchAccountTable(1); 
            }
        }
    });

    // Handle next button click with animation
    next.click(function () {
        if ($(".sidebar__item1").hasClass("sidebar_active")) {
            currentPageDep++;

            $(".department_table").fadeOut(300, function () {
                if (option === "None") {
                    fetchDepartmentTable(currentPageDep); 
                } else {
                    currentPageDepFilter++;
                    if (option.includes("Type")) {
                        filterDepartmentByType(typeText.toUpperCase(), currentPageDepFilter);
                    } else if (option.includes("ID")) {
                        filterDepartmentByID(minValue, maxValue, currentPageDepFilter);
                    } else if (option.includes("Member")) {
                        filterDepartmentByTotalMember(minValue, maxValue, currentPageDepFilter);
                    } else if (option.includes("Date")) {
                        filterDepartmentByCreatedDate(minValue, maxValue, currentPageDepFilter);
                    } else if (option.includes("Year")) {
                        filterDepartmentByYear(minValue, maxValue, currentPageDepFilter);
                    } else if (option.includes("Quantity")) {
                        filterDepartmentByAccountQuantity(minValue, maxValue, currentPageDepFilter);
                    }
                }
                $(".department_table").fadeIn(300); 
            });
        }

        if ($(".sidebar__item2").hasClass("sidebar_active")) {
            currentPageAcc++;

            $(".account_table").fadeOut(300, function () {
                if (option === "None") {
                    fetchAccountTable(currentPageAcc); 
                } else {
                    currentPageAccFilter++;
                    if (option.includes("Type")) {
                        filterAccountByDepartmentType(typeText.toUpperCase(), currentPageAccFilter);
                    }
                }
                $(".account_table").fadeIn(300); 
            });
        }
    });

});
