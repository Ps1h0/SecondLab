// $(function(){

    $("#divMySchedule").load("../html/schedule.html");

    $('.divRight').click(function (event) {

        $('#divMain').addClass('displayShow');
        $('#divMySchedule').addClass('displayShow');
        $('#divMySubjects').addClass('displayShow');
        $('#divMyGroups').addClass('displayShow');

          var target = $( event.target );
          if ( target.is( "#myMain" ) ) {
            $('#divMain').toggleClass('displayShow');
          }
          if ( target.is( "#mySchedule" ) ) {
            $('#divMySchedule').toggleClass('displayShow');
          }
          if ( target.is( "#mySubject" ) ) {
            $('#divMySubjects').toggleClass('displayShow');
          }
          if ( target.is( "#myGroups" ) ) {
            $('#divMyGroups').toggleClass('displayShow');
          }
    })
        
// });