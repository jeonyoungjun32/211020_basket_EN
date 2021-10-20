
$(function () {
	AOS.init();
});
    
$(function () {
    var $header = $('header');
    var $headerBtn = $('.header_btn');

    $headerBtn.on('click',function(){
        $header.toggleClass('open');
        if($header.hasClass('open')) {
            $header.animate({top : -170},300);
            $headerBtn.attr({
                src : 'img/menu_line.png',
                alt : '헤더 닫기 버튼'
            })
        } else {
            $header.animate({top : 0},300);
            $headerBtn.attr({
                src : 'img/close_line.png',
                alt : '헤더 열기 버튼'
            });
        };
    });
});

$(function () {
	$(document).snowfall({
		image :"img/flake.png",
		minSize: 3,
		maxSize:10, 
        flakeCount :100/*갯수 */
	});
	
    var $article = $('.article'),
        $slideGroup = $article.find('.img_box'),
        $slides = $slideGroup.find('.slide'),
        $nav = $article.find('.button_box'),
        $indicator = $article.find('.bottom_button'),
        $slideCount = $slides.length,
        $curIndex = 0,
        $indicatorHTML ='',
        $timer;
    
    // 각 슬라이드의 위치 설정
    // 해당 인디게이터의 앵커를 설정
    $slides.each(function (i) {
        $(this).css({ left: 100 * i + '%' });
        $indicatorHTML += '<a href="#">' + (i + 1) + '</a>';
        console.log($indicatorHTML); //console 테스트
    });
    $indicator.html($indicatorHTML);
    
    //슬라이드 이동 함수(모든 슬라이드 표시)
    function goToSlide(index) {
        $slideGroup.animate({ left: -100 * index + '%' }, 500);
        $curIndex = index;
    }
    
    // 타이머를 시작하는 함수, 자동 슬라이드
    function startTimer() {
        $timer = setInterval(function () {
            //cur 0, next1 / ...cur3, next0
            var $nextIndex = ($curIndex + 1) % $slideCount;
            goToSlide($nextIndex);
        }, 5000);
    }
    
    // 타이머를 중지하는 함수
    function stopTimer() {
        clearInterval($timer);
    }

    //마우스 오버시 타이머 함수 정지, 그렇지 않으면 시작
    $slideGroup.on({
        mouseenter: stopTimer,
        mouseleave: startTimer
    })

    //인디게이터의 링크를 클릭하면 해당 슬라이드 표시
    $indicator.find('a').on('click', function (e) {
        e.preventDefault();
        if (!$(this).hasClass('active')) {
            goToSlide($(this).index());
        }
    });
    //첫번째 슬라이드 표시
    goToSlide($curIndex);

    //자동슬라이드
    startTimer(); 
});

/*상품 장바구니 문의창 */
function addCartBtn(){
	if (confirm("쇼핑카트에 담으시겠습니까?")==true){
		document.cartAdd.submit();
	} else {
		alert("장바구니에 담지 못했습니다");
		return;
	}
}

function loginOut() {
	alert("로그아웃 되었습니다.");
	location="logOutPro.bk";
}