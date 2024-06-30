# Nigel Andrews
# 218838722
# nigel@ninjabot.net

import random
points = 100
round = 1

def getCardValue():
    card = random.randint(2,14)
    return card
    
def getCardStr(cardValue): 
    if cardValue == 2:
        print('YOUR CARD IS 2')
        cardValue = '2'
    elif cardValue == 3:
        cardValue = '3'
        print('YOUR CARD IS 3')
    elif cardValue == 4:
        cardValue = '4'
        print('YOUR CARD IS 4')
    elif cardValue == 5:
        cardValue = '5'
        print('YOUR CARD IS 5')
    elif cardValue == 6:
        cardValue = '6'
        print('YOUR CARD IS 6')
    elif cardValue == 7:
        cardValue = '7'
        print('YOUR CARD IS 7')
    elif cardValue == 8:
        cardValue = '8'
        print('YOUR CARD IS 8')
    elif cardValue == 9:
        cardValue = '9'
        print('YOUR CARD IS 9')
    elif cardValue == 10:
        cardValue = 'T'
        print('YOUR CARD IS T')
    elif cardValue == 11:
        cardValue = 'J'
        print('YOUR CARD IS J')
    elif cardValue == 12:
        cardValue = 'Q'
        print('YOUR CARD IS Q')
    elif cardValue == 13:
        cardValue = 'K'
        print('YOUR CARD IS K')
    elif cardValue == 14:
        cardValue = 'A'
        print('YOUR CARD IS A')

def getHLGuess():
    call = (input('HIGHER OR LOWER?[H/K]: ')).lower()
    if call == 'h':
        bettype = "HIGH"
        return bettype
    elif call =='l':
        bettype = "LOW"
        return bettype
    
    if call != 'h' or call != 'l':
        while call != 'h' or call != 'l':
            call = (input('INVALID. HIGHER OR LOWER?: ')).lower()
            if call == 'h':
                bettype = "HIGH"
                return bettype
            elif call =='l':
                bettype = "LOW"
                return bettype
                

  

def getBetAmount(maximum):
    
    bet = (int(input('HOW MUCH WILL YOU BET?: ')))
    if bet <= maximum and bet > 0:
        return bet
    else:
        while bet >= maximum or bet >= 0:
            bet = (int(input('INVALID BET. HOW MUCH WILL YOU BET?: ')))
            if bet <= maximum and bet > 0:
                return bet
    

    

def playerGuessCorrect(card1,card2,bettype):
    
    if bettype == 'HIGH' and card2 > card1:
         pointflag = True
         return pointflag
    elif bettype == 'HIGH' and card2<= card1:
         pointflag = False
         return pointflag
    elif bettype == 'LOW' and card2< card1:
         pointflag = True
         return pointflag
    elif bettype =='LOW' and card2 >= card1:
         pointflag = False
         return pointflag
        


def pointsallocation(points,bet,pointflag):
    if pointflag == True:
        points = points + bet
        return points
    elif pointflag == False:
        points = points - bet
        return points
    
def winlose(pointflag):
    if pointflag == True:
        WinOrLose = "WIN"
        return WinOrLose
    elif pointflag == False:
        WinOrLose = "LOST"
        return WinOrLose



while round <=10: 
    print("--- Welcome to High-Low --- \nStart with 100 points. Each round a card will be drawn and shown. ")
    print("Then enter the amount you want to bet. \nIf you are right, you win the amount you bet, otherwise you lose.")
    print("Try to make it to 500 points within 10 tries. ")
    print('-----------------')
    print('OVERALL POINTS:',points,".ROUND",round,"/10")

    
    card1 = getCardValue()
    getCardStr(card1)
    bettype = getHLGuess()
    bet = getBetAmount(points)
    card2 = getCardValue()
    getCardStr(card2)
    pointflag = playerGuessCorrect(card1,card2,bettype)
    points = pointsallocation(points,bet,pointflag)
    WinOrLose = winlose(pointflag)
    print("Card1[",card1,"] Card2[",card2,"] - YOU BET",bettype,"FOR",bet,"- YOU",WinOrLose)
    round = round + 1
    
    
    if points <= 0:
        print("YOU LOST ON ROUND:",round,)
        break
    elif points >= 500:
        print("YOU WON ON ROUND:",round,". WITH",points,"POINTS!")
        break
    elif  round > 10:
        print("YOU HAVE REACHED THE FINAL ROUND")
        break
        