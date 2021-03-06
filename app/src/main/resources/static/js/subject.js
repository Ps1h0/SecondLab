$(document).ready(function() {

    let x;
    let y;

    document.oncontextmenu = function () { return false; };

    // $(document).mousedown(function (event) {   
                
    //     if (event.which === 1) {
            
    //         console.log('1'); 
            
    //         $('il').click( () => {
    //             console.log(1);
    //         })

    //         x = event.pageX;
    //         y = event.pageY;

    //         document.getElementById("context-menu-date").style.display = 'none';
    //     }

    //     if (event.which === 3 && $('#divMySubject .date').attr('class') == 'date') {

            

    //     }

    // });
    

    document.oncontextmenu = function () { return false; };
 
    let field;

    $('.mark, ul').mousedown(function (event) {            

        if (event.which === 1) {
            if (event.target.parentNode.id === "show") {
                showAlert();                    
            }
            if (event.target.parentNode.id === "change") {
                changeColor();
            }

            

            field.innerText = event.target.innerText;
            document.getElementById("context-menu-date").style.display = 'none';
        }
        // console.log($(event.target)[0].nodeName);
        if (event.which === 3 && $('#divMySubject .mark').attr('class') == 'mark') {
            console.log(event.target.innerText);
            field = event.target;

            document.getElementById("context-menu-date").style.display = '';
            $('.context-menu').css({ left: event.pageX + 'px', top: event.pageY + 'px' });
        }
    });

    $('li').click( () => {
        console.log(1);
    })

    // $('#divMySubject .date').click( () => {
    //     let position = $('#divMySubject .date').offset();
    //     console.log(x);
    //     console.log(y);
    //     document.getElementById("context-menu-date").style.display = '';
    //     $('context-menu').css({'left': x + 'px', 'top': y + 'px'});
    // })

    

});