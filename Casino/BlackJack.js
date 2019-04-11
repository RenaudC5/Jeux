var suits = ["S", "H", "D", "C"];
var values = ["2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"];
var deck = new Array();

//total for each player
var playerTotal = 0;
var dealerTotal = 0;
//current card in the deck
var currentCard = 0;

//number of wins for each players (stats)
var playerWins = 0;
var dealerWins = 0;
var playing = true;

//money at the start of the game and bet size
var argent = 50000;
var mise = 10;
//boolean for the game
var blackJack = false;
var joueurDouble = false;
var isAce = false;

createDeck();
shuffle();

function onload() {
  document.getElementById("hitButton").disabled = true;
  document.getElementById("stayButton").disabled = true;
  document.getElementById("doubleButton").disabled = true;
  //soloPlaying(1000);
}

function playerCard(){
  playerTotal = playerTotal + deck[currentCard].Weight;
  var carte = deck[currentCard].Value+deck[currentCard].Suit;
  document.getElementById('playerCards').innerHTML += '<li><img src="img/'+carte+'.png" width="100" height="152"></li>';


    currentCard++;
    setPlayerTotal();
}

function dealerCard(){
  var carte = deck[currentCard].Value+deck[currentCard].Suit;
  dealerTotal = dealerTotal + deck[currentCard].Weight;

  document.getElementById('dealerCards').innerHTML += '<li><img src="img/'+carte+'.png" width="100" height="152"></li>';


    currentCard++;
    setDealerTotal();
}

function createDeck(){
       deck = new Array();
       for(var j=0;j<1000;j++){
         for (var i = 0 ; i < values.length; i++){
             for(var x = 0; x < suits.length; x++){
                 var weight = parseInt(values[i]);
                 if (values[i] == "J" || values[i] == "Q" || values[i] == "K")
                     weight = 10;
                 if (values[i] == "A")
                     weight = 11;
                 var card = { Value: values[i], Suit: suits[x], Weight: weight };
                 deck.push(card);
             }
         }
       }

   }

function startGame(){
  blackJack = false;
  joueurDouble = false;
  argent = argent - mise;
  var ul = document.getElementById("playerCards");
  while(ul.firstChild) ul.removeChild(ul.firstChild);

  var ul2 = document.getElementById("dealerCards");
  while(ul2.firstChild) ul2.removeChild(ul2.firstChild);

  document.getElementById("hitButton").disabled = false;
  document.getElementById("stayButton").disabled = false;
  document.getElementById("doubleButton").disabled = false;

  playerTotal = 0;
  dealerTotal = 0;
  setPlayerTotal();
  setDealerTotal();
  playerCard();
  playerCard();
  if(playerTotal) blackJack = true;
  dealerCard();


}

function endGame(){
  playing = false;
  if(document.getElementById("dealerCards").getElementsByTagName("li").length == 1) dealerCard();
  if(playerTotal > dealerTotal && playerTotal < 22 || playerTotal < dealerTotal && dealerTotal > 21 && playerTotal < 22){ //player win
    if(double) argent = argent + (mise * 2);
    else if(blackJack) argent = argent + (mise * 1,5);
    else argent = argent + mise;
    mise = 10;
    playerWins++;
  } else if(playerTotal == dealerTotal){
      if(double) argent = argent + (mise*2);
      else argent = argent + mise;
  } else {
    mise = mise*2;
    dealerWins++;
  }

  updateArgent();


}
function hit(){
  playerCard();
  if(playerTotal >= 21) {
    stay();
  }
}
function stay(){
  document.getElementById("hitButton").disabled = true;
  document.getElementById("stayButton").disabled = true;
  document.getElementById("doubleButton").disabled = true;
  while(dealerTotal < 16 && playerTotal <= 21) dealerCard();
  endGame();
}
function double(){
  joueurDouble = true;
  argent = argent - mise;
  updateArgent();
  playerCard();
  stay();
}
function split(){
}

function shuffle(){
        // for 1000 turns
        // switch the values of two random cards
        for (var i = 0; i < 10000000; i++){
            var location1 = Math.floor((Math.random() * deck.length));
            var location2 = Math.floor((Math.random() * deck.length));
            var tmp = deck[location1];

            deck[location1] = deck[location2];
            deck[location2] = tmp;
        }
}
function setPlayerTotal(){
  document.getElementById("playerTotal").innerHTML = "Player : "+playerTotal;
}

function setDealerTotal(){
  document.getElementById("dealerTotal").innerHTML = "Dealer : "+dealerTotal;
}

function decision(){
  //il faut hit
  if(playerTotal <= 8 ||
  (playerTotal == 9 && dealerTotal == 2) ||
  (dealerTotal >= 7 && playerTotal == 9) ||
  (dealerTotal >=10 && playerTotal == 10) ||
  (playerTotal == 11 && dealerTotal == 11) ||
  (playerTotal == 12 && (dealerTotal < 4 || dealerTotal > 6)) ||
  (playerTotal == 13 && dealerTotal > 6) ||
  (playerTotal == 14 && dealerTotal > 6) ||
  (playerTotal == 15 && dealerTotal > 6) ||
  (playerTotal == 16 && dealerTotal > 6)){
    hit();
  } else if (
    ((dealerTotal > 2 && dealerTotal < 7) && playerTotal == 9) ||
    (playerTotal == 10 && dealerTotal < 10) ||
    (playerTotal == 11 && dealerTotal < 11)
  ){//if faut double
    double();
  } else stay();


  //il faut stay()
}

function soloPlaying(sum){
  var i = 0;

  while(i < sum){
    playing = true;
    //soloPlaying
    startGame();
    while(playing) decision();
    setTimeout(function(){
    }, 1000);
    i++;
  }
  console.log("nombre de win dealer : "+dealerWins);
  console.log("nombre de win joueur : "+playerWins);
}

function updateArgent(){
  console.log("argent : "+argent);
  document.getElementById("argentPlayer").innerHTML = argent + " €";
}
