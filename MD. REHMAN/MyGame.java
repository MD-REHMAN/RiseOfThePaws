package com.innolat.crash;

import java.nio.channels.SelectableChannel;

import com.innolat.crash.R;

//import com.example.myanimation.R;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class MyGame extends View {
	
	SQLiteDatabase dataBase;
	
	Bitmap myCar, laneLine, grass, obsCar1, obsCar2, obsCar3, obsCar4, obsCar5, start, cr, ash, playIcon, garageIcon, howToPlayIcon, howToPlay, aboutUsIcon, aboutUs, exitIcon;
	Bitmap game, over, score, mainMenu, retry, loading, select, highScore;
	Bitmap one, two, three, four, five, six, seven, eight, nine, zero;
	Bitmap carBody1, carBody2, carBody3, carBody4, carBody5, carBody6, carBody7, carBody8, carBody9, carBody10, carBody11, carBody12, carBody13, carBody14, carBody15, carBody16;
	Bitmap carGlass1, carGlass2, carGlass3, carGlass4, carGlass5, carGlass6, carGlass7, carGlass8, carGlass9, carGlass10, carGlass11, carGlass12, carGlass13, carGlass14, carGlass15, carGlass16, carGlass17, carGlass18;
	Bitmap carTatto1, carTatto2, carTatto3, carTatto4, carTatto5, carTatto6, carTatto7, carTatto8, carTatto9, carTatto10;
	Bitmap carStrip1, carStrip2, carStrip3, carStrip4;
	Bitmap carShadow, platform, blast, next, previous;
	Bitmap tree, glassBlue, glassRed, instruction1, instruction2, instruction3, instruction4;
	
	
	Paint paint;
	Paint paintBlack = new Paint();
	Paint paintGrey = new Paint();
	
	Rect rect = new Rect();
	Thread thread;
	
	
	
	int screenControler=-1, isGameover=0, iconSelecter, carSelecter;
	int Time=0, Score=0, HighScore=0;
	int numberOne=0, numberTwo=0;
	int scoreElement[] = new int[6];
	int highScoreElement[] = new int[6];
	int key1, key2, key3, key4;
	int selectedCarBody=1, selectedCarGlass=1, selectedCarTatto=0, selectedCarStrip=1;
	int checkRed=0, checkBlue=0;
	int atempvat=0;
	
	
	float devWidth, devHeight, devUnitWidth, devUnitHeight;
	float cr_x, ash_x,game_x, over_x;
	float score_x[] = new float[6];
	float touch_x, touch_y;
	float lane1, lane2, laneWidth, laneIniPosition, carCentreAlign=0;
	float speed=5;
	float myCarX, myCarY;
	float carPos1, carPos2, carPos3, carPos4, obsCar1_y, obsCar2_y, obsCar3_y, obsCar4_y;
	float obscar1_speed, obscar2_speed, obscar3_speed, obscar4_speed;
	
	public MyGame(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		myCar = BitmapFactory.decodeResource(getResources(), R.drawable.mycar);
		laneLine = BitmapFactory.decodeResource(getResources(), R.drawable.laneline);
		grass = BitmapFactory.decodeResource(getResources(), R.drawable.grass);
		obsCar1 = BitmapFactory.decodeResource(getResources(), R.drawable.obscar1);
		obsCar2 = BitmapFactory.decodeResource(getResources(), R.drawable.obscar2);
		obsCar3 = BitmapFactory.decodeResource(getResources(), R.drawable.obscar3);
		obsCar4 = BitmapFactory.decodeResource(getResources(), R.drawable.obscar4);
		start = BitmapFactory.decodeResource(getResources(), R.drawable.start);
		cr = BitmapFactory.decodeResource(getResources(), R.drawable.cr);
		ash = BitmapFactory.decodeResource(getResources(), R.drawable.ash);
		game = BitmapFactory.decodeResource(getResources(), R.drawable.game);
		over = BitmapFactory.decodeResource(getResources(), R.drawable.over);
		playIcon = BitmapFactory.decodeResource(getResources(), R.drawable.playicon);
		garageIcon = BitmapFactory.decodeResource(getResources(), R.drawable.garageicon);
		howToPlayIcon = BitmapFactory.decodeResource(getResources(), R.drawable.howtoplayicon);
		howToPlay = BitmapFactory.decodeResource(getResources(), R.drawable.howtoplay);
		aboutUsIcon = BitmapFactory.decodeResource(getResources(), R.drawable.aboutusicon);
		aboutUs = BitmapFactory.decodeResource(getResources(), R.drawable.aboutus);
		exitIcon = BitmapFactory.decodeResource(getResources(), R.drawable.exiticon);
		retry = BitmapFactory.decodeResource(getResources(), R.drawable.retry);
		loading = BitmapFactory.decodeResource(getResources(), R.drawable.loading);
		score = BitmapFactory.decodeResource(getResources(), R.drawable.score);
		mainMenu = BitmapFactory.decodeResource(getResources(), R.drawable.mainmenu);
		next = BitmapFactory.decodeResource(getResources(), R.drawable.next);
		previous = BitmapFactory.decodeResource(getResources(), R.drawable.previous);
		select = BitmapFactory.decodeResource(getResources(), R.drawable.select);
		highScore = BitmapFactory.decodeResource(getResources(), R.drawable.highscore);
		
		
		
		
		one = BitmapFactory.decodeResource(getResources(), R.drawable.one);
		two = BitmapFactory.decodeResource(getResources(), R.drawable.two);
		three = BitmapFactory.decodeResource(getResources(), R.drawable.three);
		four = BitmapFactory.decodeResource(getResources(), R.drawable.four);
		five = BitmapFactory.decodeResource(getResources(), R.drawable.five);
		six = BitmapFactory.decodeResource(getResources(), R.drawable.six);
		seven = BitmapFactory.decodeResource(getResources(), R.drawable.seven);
		eight = BitmapFactory.decodeResource(getResources(), R.drawable.eight);
		nine = BitmapFactory.decodeResource(getResources(), R.drawable.nine);
		zero = BitmapFactory.decodeResource(getResources(), R.drawable.zero);
		
		
		platform = BitmapFactory.decodeResource(getResources(), R.drawable.platform);
		blast = BitmapFactory.decodeResource(getResources(), R.drawable.blast);
		carShadow = BitmapFactory.decodeResource(getResources(), R.drawable.carshadow);
		
		carBody1 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody1);
		carBody2 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody2);
		carBody3 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody3);
		carBody4 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody4);
		carBody5 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody5);
		carBody6 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody6);
		carBody7 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody7);
		carBody8 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody8);
		carBody9 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody9);
		carBody10 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody10);
		carBody11 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody11);
		carBody12 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody12);
		carBody13 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody13);
		carBody14 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody14);
		carBody15 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody15);
		carBody16 = BitmapFactory.decodeResource(getResources(), R.drawable.carbody16);
		
		carGlass1 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass1);
		carGlass2 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass2);
		carGlass3 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass3);
		carGlass4 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass4);
		carGlass5 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass5);
		carGlass6 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass6);
		carGlass7 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass7);
		carGlass8 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass8);
		carGlass9 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass9);
		carGlass10 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass10);
		carGlass11 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass11);
		carGlass12 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass12);
		carGlass13 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass13);
		carGlass14 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass14);
		carGlass15 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass15);
		carGlass16 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass16);
		carGlass17 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass17);
		carGlass18 = BitmapFactory.decodeResource(getResources(), R.drawable.carglass18);
		
		carTatto1 = BitmapFactory.decodeResource(getResources(), R.drawable.cartatto1);
		carTatto2 = BitmapFactory.decodeResource(getResources(), R.drawable.cartatto2);
		carTatto3 = BitmapFactory.decodeResource(getResources(), R.drawable.cartatto3);
		carTatto4 = BitmapFactory.decodeResource(getResources(), R.drawable.cartatto4);
		carTatto5 = BitmapFactory.decodeResource(getResources(), R.drawable.cartatto5);
		carTatto6 = BitmapFactory.decodeResource(getResources(), R.drawable.cartatto6);
		carTatto7 = BitmapFactory.decodeResource(getResources(), R.drawable.cartatto7);
		carTatto8 = BitmapFactory.decodeResource(getResources(), R.drawable.cartatto8);
		carTatto9 = BitmapFactory.decodeResource(getResources(), R.drawable.cartatto9);
		carTatto10 = BitmapFactory.decodeResource(getResources(), R.drawable.cartatto10);
		
		carStrip1 = BitmapFactory.decodeResource(getResources(), R.drawable.carstrip1);
		carStrip2 = BitmapFactory.decodeResource(getResources(), R.drawable.carstrip2);
		carStrip3 = BitmapFactory.decodeResource(getResources(), R.drawable.carstrip3);
		carStrip4 = BitmapFactory.decodeResource(getResources(), R.drawable.carstrip4);
		
		tree = BitmapFactory.decodeResource(getResources(), R.drawable.tree);
		glassBlue = BitmapFactory.decodeResource(getResources(), R.drawable.glassblue);
		glassRed = BitmapFactory.decodeResource(getResources(), R.drawable.glassred);
		
		instruction1 = BitmapFactory.decodeResource(getResources(), R.drawable.instruction1);
		instruction2 = BitmapFactory.decodeResource(getResources(), R.drawable.instruction2);
		instruction3 = BitmapFactory.decodeResource(getResources(), R.drawable.instruction3);
		instruction4 = BitmapFactory.decodeResource(getResources(), R.drawable.instruction4);
		
	}


	/* (non-Javadoc)
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		
		
		rect.set(0, 0, canvas.getWidth(), canvas.getHeight());

		paintBlack.setStyle(Paint.Style.FILL);
		paintBlack.setARGB(255, 0, 0, 0);
		canvas.drawRect(rect, paintBlack);
		
		
		switch (screenControler) {
		
		case -2: //Score Calculator
			
			drawLoading(((devWidth-loading.getWidth())/2), ((devHeight-loading.getHeight())/2), canvas);
			
			if(Score<=HighScore) {
				for (int i = 0; i < scoreElement.length; i++) {
					scoreElement[i] = Score % 10;
					Score = Score / 10;
				}
			} else {
				HighScore=Score;
				for (int i = 0; i < scoreElement.length; i++) {
					scoreElement[i] = Score % 10;
					highScoreElement[i] = scoreElement[i];
					Score = Score / 10;
				}
			}
			screenControler=4;
			break;
		
		case -1: //Initialization
			
			drawLoading(((devWidth-loading.getWidth())/2), ((devHeight-loading.getHeight())/2), canvas);
			
			Time=0;
			Score=0;
			
			speed=0;
			
			numberOne=0;
			numberTwo=0;
			
			checkRed=0;
			checkBlue=0;
			atempvat=0;
			
			
			iconSelecter=0;
			
			devWidth=canvas.getWidth();
			devHeight=canvas.getHeight();
			devUnitWidth = devWidth/100;
			devUnitHeight = devHeight/100;
			
			cr_x=-100-cr.getWidth();
			ash_x=devWidth+10;
			
			game_x=-100-game.getWidth();
			over_x=devWidth+100;
			
			
			lane1=devHeight-laneLine.getHeight();
			lane2=devHeight-(2*laneLine.getHeight());
			laneIniPosition=devHeight-(2*laneLine.getHeight());;
			
			laneWidth=(canvas.getWidth()-2*grass.getWidth())/4;
			if (laneWidth>myCar.getWidth()) {
				carCentreAlign=(laneWidth-myCar.getWidth())/2;	
			}
			
			myCarX=(devWidth/2)+carCentreAlign;
			myCarY=devUnitHeight*80;
			
			carPos1=myCarX-2*laneWidth;
			carPos2=myCarX-laneWidth;
			carPos3=myCarX;
			carPos4=myCarX+laneWidth;
			
			obsCar1_y=-devUnitHeight*15;
			obsCar2_y=-devUnitHeight*87*2;
			obsCar3_y=-devUnitHeight*140;
			obsCar4_y=-devUnitHeight*92;
			
			
			
		
			score_x[0]=(devWidth/2)+(2*one.getWidth());
			score_x[1]=(devWidth/2)+one.getWidth();
			score_x[2]=devWidth/2;
			score_x[3]=(devWidth/2)-one.getWidth();
			score_x[4]=(devWidth/2)-(2*one.getWidth());
			score_x[5]=(devWidth/2)-(3*one.getWidth());
			
			if (isGameover==0) {
				screenControler=0;
			} else {
				screenControler=1;
			}
			
			break;
		
		case 0: //Home Screen
			
			drawStart(((devWidth-start.getWidth())/2),((devHeight-start.getHeight())/2), canvas);
			drawCr(cr_x,devUnitHeight*10, canvas);
			drawAsh(ash_x,devUnitHeight*10, canvas);
			
			if ((cr_x+cr.getWidth())<=((devWidth/2)-(cr.getWidth()/4))) {
				cr_x=cr_x+9;
			}
			if (ash_x>=((devWidth/2)-(cr.getWidth()/4))) {
				ash_x=ash_x-9;
			} else {
				
				drawPlayIcon(((devWidth-playIcon.getWidth())/2), devUnitHeight*25, canvas);
				drawGarageIcon(((devWidth-garageIcon.getWidth())/2), devUnitHeight*40, canvas);
				drawHowToPlayIcon(((devWidth-howToPlayIcon.getWidth())/2), devUnitHeight*55, canvas);
				drawAboutUsIcon(((devWidth-aboutUsIcon.getWidth())/2), devUnitHeight*70, canvas);
				drawExitIcon(((devWidth-exitIcon.getWidth())/2), devUnitHeight*85, canvas);
				
				setOnTouchListener(new View.OnTouchListener() {
					
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub
						
						switch (event.getAction()) {
						case MotionEvent.ACTION_DOWN:
							touch_x=event.getX();
							touch_y=event.getY();
							break;
						default:
							break;
						}
						
						if (touch_x>=((devWidth-playIcon.getWidth())/2) && touch_x<=((devWidth-playIcon.getWidth())/2)+playIcon.getWidth() && touch_y>=devUnitHeight*25 && touch_y<=(devUnitHeight*25)+playIcon.getHeight())  {
							//Play
							iconSelecter=1;
							
						}
						else if (touch_x>=((devWidth-garageIcon.getWidth())/2) && touch_x<=((devWidth-garageIcon.getWidth())/2)+garageIcon.getWidth() && touch_y>=devUnitHeight*40 && touch_y<=(devUnitHeight*40)+garageIcon.getHeight())  {
							//Play
							iconSelecter=5;
							
						}
						else if (touch_x>=((devWidth-howToPlayIcon.getWidth())/2) && touch_x<=((devWidth-howToPlayIcon.getWidth())/2)+howToPlayIcon.getWidth() && touch_y>=devUnitHeight*55 && touch_y<=(devUnitHeight*55)+howToPlayIcon.getHeight())  {
							//How To Play
							iconSelecter=2;
							
						}
						else if (touch_x>=((devWidth-aboutUsIcon.getWidth())/2) && touch_x<=((devWidth-aboutUsIcon.getWidth())/2)+aboutUsIcon.getWidth() && touch_y>=devUnitHeight*70 && touch_y<=(devUnitHeight*70)+aboutUsIcon.getHeight())  {
							//About Us
							iconSelecter=3;
							
						}
						else if (touch_x>=((devWidth-exitIcon.getWidth())/2) && touch_x<=((devWidth-exitIcon.getWidth())/2)+exitIcon.getWidth() && touch_y>=devUnitHeight*85 && touch_y<=(devUnitHeight*85)+exitIcon.getHeight())  {
							//Exit
							iconSelecter=4;
						}
						else if (touch_x>=cr_x && touch_x<=cr_x+cr.getWidth() && touch_y>=devUnitHeight*10 && touch_y<=devUnitHeight*10+cr.getHeight())  {
							//Exit
							cr_x=-100-cr.getWidth();
							ash_x=devWidth+10;
						}
						else if (touch_x>=ash_x && touch_x<=ash_x+ash.getWidth() && touch_y>=devUnitHeight*10 && touch_y<=devUnitHeight*10+ash.getHeight())  {
							//Exit
							cr_x=-100-cr.getWidth();
							ash_x=devWidth+10;
						}
						
						
						return false;
					}
				});
				
			}
			
			

			
			switch (iconSelecter) {
			case 1:
				//Play
				try {
					thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				screenControler=1;
				
				break;
			case 2:
				//How To Play
				try {
					thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				screenControler=2;
				
				break;
			case 3:
				//About Us
				try {
					thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				screenControler=3;
				
				break;
			case 4:
				//Exit
				try {
					thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				System.exit(1);
				
				break;
			case 5:
				//Garage
				drawExitIcon(((devWidth-start.getWidth())/2),((devHeight-start.getHeight())/2), canvas);
				try {
					thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				screenControler=5;
				
				break;

			default:
				break;
			}
			
			break;
		case 1: //Play Screen
			
			if (Score>=999999) {
				Score=999999;
				screenControler=-2;
			}
			
			paintGrey.setStyle(Paint.Style.FILL);
			paintGrey.setARGB(255, 91, 91, 91);
			canvas.drawRect(rect, paintGrey);
			
			//Speed
			if (speed<devUnitHeight*0.3f) {
				speed = speed + (devUnitHeight/200);
				Score=Score+1;
				Time++;
			}
			else if (speed<devUnitHeight*0.6f) {
				speed = speed + (devUnitHeight/300);
				Time++;
				Score=Score+2;
			}
			else if (speed<devUnitHeight*0.9f) {
				speed = speed + (devUnitHeight/500);
				Time++;
				Score=Score+4;
			}
			else if (speed<devUnitHeight*1.2f) {
				speed = speed + (devUnitHeight/700);
				Time++;
				Score=Score+5;
			}
			else if (speed<devUnitHeight*1.5f) {
				speed = speed + (devUnitHeight/900);
				Time++;
				Score=Score+7;
			}
			else if (speed<devUnitHeight*1.8f) {
				speed = speed + (devUnitHeight/1000);
				Time++;
				Score=Score+10;
			}
			else if (speed<devUnitHeight*2.1f) {
				speed = speed + (devUnitHeight/1000);
				Time++;
				Score=Score+13;
			}
			else if (speed<devUnitHeight*2.4f) {
				speed = speed + (devUnitHeight/1100);
				Time++;
				Score=Score+17;
			}
			else if (speed<devUnitHeight*2.7f) {
				speed = speed + (devUnitHeight/1200);
				Time++;
				Score=Score+20;
			}
			else if (speed<devUnitHeight*3.0f) {
				speed = speed + (devUnitHeight/1300);
				Time++;
				Score=Score+25;
			}
			else {
				speed = speed + (devUnitHeight/2000);
				Time++;
				Score=Score+50;
			}
			
			// Drawing Grass and tree
			drawGrass(0, devHeight-grass.getHeight(), canvas);
			drawGrass(devWidth-grass.getWidth(), devHeight-grass.getHeight(), canvas);
			if (grass.getHeight()/devHeight==1) {
				drawGrass(0,(devHeight-grass.getHeight()-grass.getHeight()), canvas);
				drawGrass(devWidth-grass.getWidth(), devHeight-grass.getHeight(), canvas);
			}
			
			
			//Drawing Lane Line
			drawLaneLine((devWidth/2-laneLine.getWidth()/2)-laneWidth, lane1, canvas);
			drawLaneLine((devWidth/2-laneLine.getWidth()/2), lane1, canvas);
			drawLaneLine((devWidth/2-laneLine.getWidth()/2)+laneWidth, lane1, canvas);
			
			drawLaneLine((devWidth/2-laneLine.getWidth()/2)-laneWidth, lane2, canvas);
			drawLaneLine((devWidth/2-laneLine.getWidth()/2), lane2, canvas);
			drawLaneLine((devWidth/2-laneLine.getWidth()/2)+laneWidth, lane2, canvas);
			
			if (lane1<=devHeight) {
				lane1=lane1+speed;
			} else {
				lane1=laneIniPosition;
			}
			if (lane2<=devHeight) {
				lane2=lane2+speed;
			} else {
				lane2=laneIniPosition;
			}
			
			//Drawing Obsticals and Moving
			drawObsCar1(carPos1, obsCar1_y, canvas);
			drawObsCar2(carPos2, obsCar2_y, canvas);
			drawObsCar3(carPos3, obsCar3_y, canvas);
			drawObsCar4(carPos4, obsCar4_y, canvas);
						
			
			//Drawing and Controlling myCar 
			drawCarShadow(myCarX, myCarY, canvas);
			
			
			//Selecting Body
			switch (selectedCarBody) {
			case 1:
				drawCarBody1(myCarX, myCarY, canvas);
				break;
			case 2:
				drawCarBody2(myCarX, myCarY, canvas);
				break;
			case 3:
				drawCarBody3(myCarX, myCarY, canvas);
				break;
			case 4:
				drawCarBody4(myCarX, myCarY, canvas);
				break;
			case 5:
				drawCarBody5(myCarX, myCarY, canvas);
				break;
			case 6:
				drawCarBody6(myCarX, myCarY, canvas);
				break;
			case 7:
				drawCarBody7(myCarX, myCarY, canvas);
				break;
			case 8:
				drawCarBody8(myCarX, myCarY, canvas);
				break;
			case 9:
				drawCarBody9(myCarX, myCarY, canvas);
				break;
			case 10:
				drawCarBody10(myCarX, myCarY, canvas);
				break;
			case 11:
				drawCarBody11(myCarX, myCarY, canvas);
				break;
			case 12:
				drawCarBody12(myCarX, myCarY, canvas);
				break;
			case 13:
				drawCarBody13(myCarX, myCarY, canvas);
				break;
			case 14:
				drawCarBody14(myCarX, myCarY, canvas);
				break;
			case 15:
				drawCarBody15(myCarX, myCarY, canvas);
				break;
			case 16:
				drawCarBody16(myCarX, myCarY, canvas);
				break;
			default:
				break;
			}
			
			//Selecting Glass
			switch (selectedCarGlass) {
			case 1:
				drawCarGlass1(myCarX, myCarY, canvas);
				break;
			case 2:
				drawCarGlass2(myCarX, myCarY, canvas);
				break;
			case 3:
				drawCarGlass3(myCarX, myCarY, canvas);
				break;
			case 4:
				drawCarGlass4(myCarX, myCarY, canvas);
				break;
			case 5:
				drawCarGlass5(myCarX, myCarY, canvas);
				break;
			case 6:
				drawCarGlass6(myCarX, myCarY, canvas);
				break;
			case 7:
				drawCarGlass7(myCarX, myCarY, canvas);
				break;
			case 8:
				drawCarGlass8(myCarX, myCarY, canvas);
				break;
			case 9:
				drawCarGlass9(myCarX, myCarY, canvas);
				break;
			case 10:
				drawCarGlass10(myCarX, myCarY, canvas);
				break;
			case 11:
				drawCarGlass11(myCarX, myCarY, canvas);
				break;
			case 12:
				drawCarGlass12(myCarX, myCarY, canvas);
				break;
			case 13:
				drawCarGlass13(myCarX, myCarY, canvas);
				break;
			case 14:
				drawCarGlass14(myCarX, myCarY, canvas);
				break;
			case 15:
				drawCarGlass15(myCarX, myCarY, canvas);
				break;
			case 16:
				drawCarGlass16(myCarX, myCarY, canvas);
				break;
			case 17:
				drawCarGlass17(myCarX, myCarY, canvas);
				break;
			case 18:
				drawCarGlass18(myCarX, myCarY, canvas);
				break;
			default:
				break;
			}
			
			//Selecting Tatto
			switch (selectedCarTatto) {
			case 0:
				break;
			case 1:
				drawCarTatto1(myCarX, myCarY, canvas);
				break;
			case 2:
				drawCarTatto2(myCarX, myCarY, canvas);
				break;
			case 3:
				drawCarTatto3(myCarX, myCarY, canvas);
				break;
			case 4:
				drawCarTatto4(myCarX, myCarY, canvas);
				break;
			case 5:
				drawCarTatto5(myCarX, myCarY, canvas);
				break;
			case 6:
				drawCarTatto6(myCarX, myCarY, canvas);
				break;
			case 7:
				drawCarTatto7(myCarX, myCarY, canvas);
				break;
			case 8:
				drawCarTatto8(myCarX, myCarY, canvas);
				break;
			case 9:
				drawCarTatto9(myCarX, myCarY, canvas);
				break;
			case 10:
				drawCarTatto10(myCarX, myCarY, canvas);
				break;
			default:
				break;
			}
			
			//Selecting Strip
			switch (selectedCarStrip) {
			case 1:
				drawCarStrip1(myCarX, myCarY, canvas);
				break;
			case 2:
				drawCarStrip2(myCarX, myCarY, canvas);
				break;
			case 3:
				drawCarStrip3(myCarX, myCarY, canvas);
				break;
			case 4:
				drawCarStrip4(myCarX, myCarY, canvas);
				break;
			default:
				break;
			}
			
			
			// Moving obsCar and Crashing
			if (obsCar1_y<=devHeight) {
				
				if ((obsCar1_y+obsCar1.getHeight())>=myCarY && obsCar1_y<=myCarY+myCar.getHeight() && myCarX==carPos1) {
					speed=0;
					screenControler=-2;
				}			
				obsCar1_y=obsCar1_y+speed-obscar1_speed;
			} else {
				if (obsCar2_y>devHeight && obsCar3_y>devHeight && obsCar4_y>devHeight) {
					
				} else {
					key1=10*(Time%10+1);
					key2=Score%10+1;
					
					obsCar1_y=-obsCar1.getHeight()-(devUnitHeight*(key1+key2))-devUnitHeight*35;
					obscar1_speed=key2;
				}
			}
			
			if (obsCar2_y<=devHeight) {

				if ((obsCar2_y+obsCar2.getHeight())>=myCarY && obsCar2_y<=myCarY+myCar.getHeight() && myCarX==carPos2) {
					speed=0;
					screenControler=-2;
				}
				obsCar2_y=obsCar2_y+speed-obscar2_speed;
			} else {
				if (obsCar1_y>devHeight && obsCar3_y>devHeight && obsCar4_y>devHeight) {
					
				} else {
					key2=10*(Score%10+1);
					key1=Time%10+1;
					
					obsCar2_y=-obsCar1.getHeight()-(devUnitHeight*(key1+key2))-devUnitHeight*90;
					obscar2_speed=key1;
				}
			}

			if (obsCar3_y<=devHeight) {

				if ((obsCar3_y+obsCar3.getHeight())>=myCarY && obsCar3_y<=myCarY+myCar.getHeight() && myCarX==carPos3) {
					speed=0;
					screenControler=-2;
				}
				obsCar3_y=obsCar3_y+speed-obscar3_speed;
			} else {
				if (obsCar1_y>devHeight && obsCar2_y>devHeight && obsCar4_y>devHeight) {
					
				} else {
					key1=10*((Time+Score)%10+1);
					key2=(Score-Time)%10+1;
					
					obsCar3_y=-obsCar1.getHeight()-(devUnitHeight*(key1+key2))-devUnitHeight*15;
					obscar3_speed=key2;
				}
			}

			if (obsCar4_y<=devHeight) {

				if ((obsCar4_y+obsCar4.getHeight())>=myCarY && obsCar4_y<=myCarY+myCar.getHeight() && myCarX==carPos4) {
					speed=0;
					screenControler=-2;
				}
				obsCar4_y=obsCar4_y+speed-obscar4_speed;
			} else {
				if (obsCar1_y>devHeight && obsCar2_y>devHeight && obsCar3_y>devHeight) {
					
				} else {
					key1=10*((Score-Time)%10+1);
					key2=(Time+Score)%10+1;
					
					obsCar4_y=-obsCar1.getHeight()-(devUnitHeight*(key1+key2))-devUnitHeight*65;
					obscar4_speed=key2;
				}
			}
						
			

			
			
			
			
			
			
			setOnTouchListener(new View.OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					
					switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						touch_x=event.getX();
						touch_y=event.getY();
						break;
					default:
						break;
					}
					if(touch_x>myCarX+(myCar.getWidth()/2) && myCarX<devWidth-grass.getWidth()-laneWidth) {
						myCarX = myCarX + laneWidth;
						Time=Time+7;
					}
					else if (touch_x<=myCarX+(myCar.getWidth()/2) && myCarX>grass.getWidth()+laneWidth) {
						myCarX = myCarX - laneWidth;
						Time=Time+3;
					}
					return false;
				}
			});
			
			
			break;
		case 2: //How To Play Screen
			
			paintGrey.setStyle(Paint.Style.FILL);
			paintGrey.setARGB(255, 91, 91, 91);
			canvas.drawRect(rect, paintGrey);
			
			//Speed
			if (speed<devUnitHeight*0.3f) {
				speed = speed + (devUnitHeight/200);
			}
			else if (speed<devUnitHeight*0.6f) {
				speed = speed + (devUnitHeight/300);
			}
			else if (speed<devUnitHeight*0.9f) {
				speed = speed + (devUnitHeight/500);
			}
			else if (speed<devUnitHeight*1.2f) {
				speed = speed + (devUnitHeight/700);
			}
			else if (speed<devUnitHeight*1.5f) {
				speed = speed + (devUnitHeight/900);
			}
			
			// Drawing Grass
			drawGrass(0, devHeight-grass.getHeight(), canvas);
			drawGrass(devWidth-grass.getWidth(), devHeight-grass.getHeight(), canvas);
			if (grass.getHeight()/devHeight==1) {
				drawGrass(0,(devHeight-grass.getHeight()-grass.getHeight()), canvas);
				drawGrass(devWidth-grass.getWidth(), devHeight-grass.getHeight(), canvas);
			}
			
			//Drawing Lane Line
			drawLaneLine((devWidth/2-laneLine.getWidth()/2)-laneWidth, lane1, canvas);
			drawLaneLine((devWidth/2-laneLine.getWidth()/2), lane1, canvas);
			drawLaneLine((devWidth/2-laneLine.getWidth()/2)+laneWidth, lane1, canvas);
			
			drawLaneLine((devWidth/2-laneLine.getWidth()/2)-laneWidth, lane2, canvas);
			drawLaneLine((devWidth/2-laneLine.getWidth()/2), lane2, canvas);
			drawLaneLine((devWidth/2-laneLine.getWidth()/2)+laneWidth, lane2, canvas);
			
			if (lane1<=devHeight) {
				lane1=lane1+speed;
			} else {
				lane1=laneIniPosition;
			}
			if (lane2<=devHeight) {
				lane2=lane2+speed;
			} else {
				lane2=laneIniPosition;
			}
			
			//Drawing Obsticals and Moving
			drawObsCar3(carPos3, obsCar3_y, canvas);
				
			
			//Drawing and Controlling myCar 
			drawCarShadow(myCarX, myCarY, canvas);
			
			
			//Selecting Body
			switch (selectedCarBody) {
			case 1:
				drawCarBody1(myCarX, myCarY, canvas);
				break;
			case 2:
				drawCarBody2(myCarX, myCarY, canvas);
				break;
			case 3:
				drawCarBody3(myCarX, myCarY, canvas);
				break;
			case 4:
				drawCarBody4(myCarX, myCarY, canvas);
				break;
			case 5:
				drawCarBody5(myCarX, myCarY, canvas);
				break;
			case 6:
				drawCarBody6(myCarX, myCarY, canvas);
				break;
			case 7:
				drawCarBody7(myCarX, myCarY, canvas);
				break;
			case 8:
				drawCarBody8(myCarX, myCarY, canvas);
				break;
			case 9:
				drawCarBody9(myCarX, myCarY, canvas);
				break;
			case 10:
				drawCarBody10(myCarX, myCarY, canvas);
				break;
			case 11:
				drawCarBody11(myCarX, myCarY, canvas);
				break;
			case 12:
				drawCarBody12(myCarX, myCarY, canvas);
				break;
			case 13:
				drawCarBody13(myCarX, myCarY, canvas);
				break;
			case 14:
				drawCarBody14(myCarX, myCarY, canvas);
				break;
			case 15:
				drawCarBody15(myCarX, myCarY, canvas);
				break;
			case 16:
				drawCarBody16(myCarX, myCarY, canvas);
				break;
			default:
				break;
			}
			
			//Selecting Glass
			switch (selectedCarGlass) {
			case 1:
				drawCarGlass1(myCarX, myCarY, canvas);
				break;
			case 2:
				drawCarGlass2(myCarX, myCarY, canvas);
				break;
			case 3:
				drawCarGlass3(myCarX, myCarY, canvas);
				break;
			case 4:
				drawCarGlass4(myCarX, myCarY, canvas);
				break;
			case 5:
				drawCarGlass5(myCarX, myCarY, canvas);
				break;
			case 6:
				drawCarGlass6(myCarX, myCarY, canvas);
				break;
			case 7:
				drawCarGlass7(myCarX, myCarY, canvas);
				break;
			case 8:
				drawCarGlass8(myCarX, myCarY, canvas);
				break;
			case 9:
				drawCarGlass9(myCarX, myCarY, canvas);
				break;
			case 10:
				drawCarGlass10(myCarX, myCarY, canvas);
				break;
			case 11:
				drawCarGlass11(myCarX, myCarY, canvas);
				break;
			case 12:
				drawCarGlass12(myCarX, myCarY, canvas);
				break;
			case 13:
				drawCarGlass13(myCarX, myCarY, canvas);
				break;
			case 14:
				drawCarGlass14(myCarX, myCarY, canvas);
				break;
			case 15:
				drawCarGlass15(myCarX, myCarY, canvas);
				break;
			case 16:
				drawCarGlass16(myCarX, myCarY, canvas);
				break;
			case 17:
				drawCarGlass17(myCarX, myCarY, canvas);
				break;
			case 18:
				drawCarGlass18(myCarX, myCarY, canvas);
				break;
			default:
				break;
			}
			
			//Selecting Tatto
			switch (selectedCarTatto) {
			case 0:
				break;
			case 1:
				drawCarTatto1(myCarX, myCarY, canvas);
				break;
			case 2:
				drawCarTatto2(myCarX, myCarY, canvas);
				break;
			case 3:
				drawCarTatto3(myCarX, myCarY, canvas);
				break;
			case 4:
				drawCarTatto4(myCarX, myCarY, canvas);
				break;
			case 5:
				drawCarTatto5(myCarX, myCarY, canvas);
				break;
			case 6:
				drawCarTatto6(myCarX, myCarY, canvas);
				break;
			case 7:
				drawCarTatto7(myCarX, myCarY, canvas);
				break;
			case 8:
				drawCarTatto8(myCarX, myCarY, canvas);
				break;
			case 9:
				drawCarTatto9(myCarX, myCarY, canvas);
				break;
			case 10:
				drawCarTatto10(myCarX, myCarY, canvas);
				break;
			default:
				break;
			}
			
			//Selecting Strip
			switch (selectedCarStrip) {
			case 1:
				drawCarStrip1(myCarX, myCarY, canvas);
				break;
			case 2:
				drawCarStrip2(myCarX, myCarY, canvas);
				break;
			case 3:
				drawCarStrip3(myCarX, myCarY, canvas);
				break;
			case 4:
				drawCarStrip4(myCarX, myCarY, canvas);
				break;
			default:
				break;
			}
			
			
			// Moving obsCar and Crashing
			if (obsCar3_y<=devHeight) {

				if ((obsCar3_y+obsCar3.getHeight())>=myCarY && obsCar3_y<=myCarY+myCar.getHeight() && myCarX==carPos3) {
					speed=0;
					
					//crashing control
					obsCar3_y=-obsCar1.getHeight()-devUnitHeight*85;
					
				}
				obsCar3_y=obsCar3_y+speed;
			} else {
				if (obsCar1_y>devHeight && obsCar2_y>devHeight && obsCar4_y>devHeight) {
					
				} else {

					//You have mastered all Controls
					drawInstruction4((devWidth-instruction4.getWidth())/2, (devHeight-instruction4.getHeight())/2, canvas);
					atempvat++;
				}
			}
			if (atempvat==200) {
				screenControler=-1;
			}
			
			if(obsCar3_y<-obsCar3.getHeight()) {
				
				if (checkBlue==0) {
					drawGlassBlue(myCarX+(carShadow.getWidth()/2), 0, canvas);
					drawInstruction1((devWidth-instruction1.getWidth())/2, (devHeight-instruction1.getHeight())/2, canvas);
					
				}
				if (checkRed==1) {
					drawGlassRed(-glassRed.getWidth()+myCarX+(carShadow.getWidth()/2), 0, canvas);
					drawInstruction2((devWidth-instruction2.getWidth())/2, (devHeight-instruction2.getHeight())/2, canvas);
				}
			} else {
				if(atempvat==0) {
				drawInstruction3((devWidth-instruction3.getWidth())/2, (devHeight-instruction3.getHeight())/2, canvas);
			
				}
			}
			
			
			setOnTouchListener(new View.OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					
					switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						touch_x=event.getX();
						touch_y=event.getY();
						break;
					default:
						break;
					}
					if(touch_x>myCarX+(myCar.getWidth()/2) && myCarX<devWidth-grass.getWidth()-laneWidth) {
						myCarX = myCarX + laneWidth;
						if (checkRed==0) {
							checkRed=1;
							checkBlue=1;
						}
						
					}
					else if (touch_x<=myCarX+(myCar.getWidth()/2) && myCarX>grass.getWidth()+laneWidth) {
						myCarX = myCarX - laneWidth;
						if(checkRed==1){
							checkRed=2;
						}
					}
					return false;
				}
			});
			
			
			break;
		case 3: //About Us Screen
			
			drawAboutUs(((devWidth-aboutUs.getWidth())/2),((devHeight-aboutUs.getHeight())/2), canvas);
			
			setOnTouchListener(new View.OnTouchListener() {
				
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					
					screenControler=-1;
					
					
					return false;
				}
			});
			
			break;
		case 4: //Gameover Screen
			
			drawStart(((devWidth-start.getWidth())/2),((devHeight-start.getHeight())/2), canvas);
			drawGame(game_x,devUnitHeight*47, canvas);
			drawOver(over_x,devUnitHeight*47, canvas);
			
			
			
			
			if (game_x+game.getWidth()<=devWidth/2) {
				game_x=game_x+9;
			}
			if (over_x>=devWidth/2) {
				over_x=over_x-9;
			} else {
			
				drawMainMenu(((devWidth-mainMenu.getWidth())/2), 0, canvas);
				drawHighScore(((devWidth-highScore.getWidth())/2), (devUnitHeight*30)-score.getHeight(), canvas);
				
				drawScore(((devWidth-score.getWidth())/2), (devUnitHeight*70)-score.getHeight(), canvas);
				drawRetry(((devWidth-retry.getWidth())/2), devHeight-retry.getHeight(), canvas);
				
				for (int i = 0; i < 6 ; i++) {
					switch (scoreElement[i]) {
					case 1:
						drawOne(score_x[i], devUnitHeight*70, canvas);
						break;
					case 2:
						drawTwo(score_x[i], devUnitHeight*70, canvas);
						break;
					case 3:
						drawThree(score_x[i], devUnitHeight*70, canvas);
						break;
					case 4:
						drawFour(score_x[i], devUnitHeight*70, canvas);
						break;
					case 5:
						drawFive(score_x[i], devUnitHeight*70, canvas);
						break;
					case 6:
						drawSix(score_x[i], devUnitHeight*70, canvas);
						break;
					case 7:
						drawSeven(score_x[i], devUnitHeight*70, canvas);
						break;
					case 8:
						drawEight(score_x[i], devUnitHeight*70, canvas);
						break;
					case 9:
						drawNine(score_x[i], devUnitHeight*70, canvas);
						break;
					default:
						drawZero(score_x[i], devUnitHeight*70, canvas);
						break;
					}
				}
				
				for (int i = 0; i < 6 ; i++) {
					switch (highScoreElement[i]) {
					case 1:
						drawOne(score_x[i], devUnitHeight*30, canvas);
						break;
					case 2:
						drawTwo(score_x[i], devUnitHeight*30, canvas);
						break;
					case 3:
						drawThree(score_x[i], devUnitHeight*30, canvas);
						break;
					case 4:
						drawFour(score_x[i], devUnitHeight*30, canvas);
						break;
					case 5:
						drawFive(score_x[i], devUnitHeight*30, canvas);
						break;
					case 6:
						drawSix(score_x[i], devUnitHeight*30, canvas);
						break;
					case 7:
						drawSeven(score_x[i], devUnitHeight*30, canvas);
						break;
					case 8:
						drawEight(score_x[i], devUnitHeight*30, canvas);
						break;
					case 9:
						drawNine(score_x[i], devUnitHeight*30, canvas);
						break;
					default:
						drawZero(score_x[i], devUnitHeight*30, canvas);
						break;
					}
				}
				

				setOnTouchListener(new View.OnTouchListener() {
					
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub
						
						switch (event.getAction()) {
						case MotionEvent.ACTION_DOWN:
							touch_x=event.getX();
							touch_y=event.getY();
							break;
						default:
							break;
						}
						
						if (touch_y>=devHeight-retry.getHeight())  {
							//Play
							screenControler=-1;
							isGameover=1;
						}
						else if(touch_y<=mainMenu.getHeight()) {
							screenControler=-1;
							isGameover=0;
						}
						
						return false;
					}
				});

			}
			break;

		case 5: // garage screen
			
			
			drawPlatform(((devWidth-platform.getWidth())/2), ((devHeight-platform.getHeight())/2), canvas);
			drawCarShadow(((devWidth-carShadow.getWidth())/2), ((devHeight-carShadow.getHeight())/2), canvas);
			drawSelect(((devWidth-select.getWidth())/2), devHeight-select.getHeight(), canvas);
			
			drawNext(devWidth-next.getWidth(), devUnitHeight*15, canvas);
			drawNext(devWidth-next.getWidth(), devUnitHeight*35, canvas);
			drawNext(devWidth-next.getWidth(), devUnitHeight*55, canvas);
			drawNext(devWidth-next.getWidth(), devUnitHeight*75, canvas);
			
			
			drawPrevious(0, devUnitHeight*15, canvas);
			drawPrevious(0, devUnitHeight*35, canvas);
			drawPrevious(0, devUnitHeight*55, canvas);
			drawPrevious(0, devUnitHeight*75, canvas);
			
			
			//Selecting Body
			switch (selectedCarBody) {
			case 1:
				drawCarBody1(((devWidth-carBody1.getWidth())/2), ((devHeight-carBody1.getHeight())/2), canvas);
				break;
			case 2:
				drawCarBody2(((devWidth-carBody2.getWidth())/2), ((devHeight-carBody2.getHeight())/2), canvas);
				break;
			case 3:
				drawCarBody3(((devWidth-carBody3.getWidth())/2), ((devHeight-carBody3.getHeight())/2), canvas);
				break;
			case 4:
				drawCarBody4(((devWidth-carBody4.getWidth())/2), ((devHeight-carBody4.getHeight())/2), canvas);
				break;
			case 5:
				drawCarBody5(((devWidth-carBody5.getWidth())/2), ((devHeight-carBody5.getHeight())/2), canvas);
				break;
			case 6:
				drawCarBody6(((devWidth-carBody6.getWidth())/2), ((devHeight-carBody6.getHeight())/2), canvas);
				break;
			case 7:
				drawCarBody7(((devWidth-carBody7.getWidth())/2), ((devHeight-carBody7.getHeight())/2), canvas);
				break;
			case 8:
				drawCarBody8(((devWidth-carBody8.getWidth())/2), ((devHeight-carBody8.getHeight())/2), canvas);
				break;
			case 9:
				drawCarBody9(((devWidth-carBody9.getWidth())/2), ((devHeight-carBody9.getHeight())/2), canvas);
				break;
			case 10:
				drawCarBody10(((devWidth-carBody10.getWidth())/2), ((devHeight-carBody10.getHeight())/2), canvas);
				break;
			case 11:
				drawCarBody11(((devWidth-carBody11.getWidth())/2), ((devHeight-carBody11.getHeight())/2), canvas);
				break;
			case 12:
				drawCarBody12(((devWidth-carBody12.getWidth())/2), ((devHeight-carBody12.getHeight())/2), canvas);
				break;
			case 13:
				drawCarBody13(((devWidth-carBody13.getWidth())/2), ((devHeight-carBody13.getHeight())/2), canvas);
				break;
			case 14:
				drawCarBody14(((devWidth-carBody14.getWidth())/2), ((devHeight-carBody14.getHeight())/2), canvas);
				break;
			case 15:
				drawCarBody15(((devWidth-carBody15.getWidth())/2), ((devHeight-carBody15.getHeight())/2), canvas);
				break;
			case 16:
				drawCarBody16(((devWidth-carBody16.getWidth())/2), ((devHeight-carBody16.getHeight())/2), canvas);
				break;
			default:
				break;
			}
			
			//Selecting Glass
			switch (selectedCarGlass) {
			case 1:
				drawCarGlass1(((devWidth-carGlass1.getWidth())/2), ((devHeight-carGlass1.getHeight())/2), canvas);
				break;
			case 2:
				drawCarGlass2(((devWidth-carGlass2.getWidth())/2), ((devHeight-carGlass2.getHeight())/2), canvas);
				break;
			case 3:
				drawCarGlass3(((devWidth-carGlass3.getWidth())/2), ((devHeight-carGlass3.getHeight())/2), canvas);
				break;
			case 4:
				drawCarGlass4(((devWidth-carGlass4.getWidth())/2), ((devHeight-carGlass4.getHeight())/2), canvas);
				break;
			case 5:
				drawCarGlass5(((devWidth-carGlass5.getWidth())/2), ((devHeight-carGlass5.getHeight())/2), canvas);
				break;
			case 6:
				drawCarGlass6(((devWidth-carGlass6.getWidth())/2), ((devHeight-carGlass6.getHeight())/2), canvas);
				break;
			case 7:
				drawCarGlass7(((devWidth-carGlass7.getWidth())/2), ((devHeight-carGlass7.getHeight())/2), canvas);
				break;
			case 8:
				drawCarGlass8(((devWidth-carGlass8.getWidth())/2), ((devHeight-carGlass8.getHeight())/2), canvas);
				break;
			case 9:
				drawCarGlass9(((devWidth-carGlass9.getWidth())/2), ((devHeight-carGlass9.getHeight())/2), canvas);
				break;
			case 10:
				drawCarGlass10(((devWidth-carGlass10.getWidth())/2), ((devHeight-carGlass10.getHeight())/2), canvas);
				break;
			case 11:
				drawCarGlass11(((devWidth-carGlass11.getWidth())/2), ((devHeight-carGlass11.getHeight())/2), canvas);
				break;
			case 12:
				drawCarGlass12(((devWidth-carGlass12.getWidth())/2), ((devHeight-carGlass12.getHeight())/2), canvas);
				break;
			case 13:
				drawCarGlass13(((devWidth-carGlass13.getWidth())/2), ((devHeight-carGlass13.getHeight())/2), canvas);
				break;
			case 14:
				drawCarGlass14(((devWidth-carGlass14.getWidth())/2), ((devHeight-carGlass14.getHeight())/2), canvas);
				break;
			case 15:
				drawCarGlass15(((devWidth-carGlass15.getWidth())/2), ((devHeight-carGlass15.getHeight())/2), canvas);
				break;
			case 16:
				drawCarGlass16(((devWidth-carGlass16.getWidth())/2), ((devHeight-carGlass16.getHeight())/2), canvas);
				break;
			case 17:
				drawCarGlass17(((devWidth-carGlass17.getWidth())/2), ((devHeight-carGlass17.getHeight())/2), canvas);
				break;
			case 18:
				drawCarGlass18(((devWidth-carGlass18.getWidth())/2), ((devHeight-carGlass18.getHeight())/2), canvas);
				break;
			default:
				break;
			}
			
			//Selecting Tatto
			switch (selectedCarTatto) {
			case 1:
				drawCarTatto1(((devWidth-carTatto1.getWidth())/2), ((devHeight-carTatto1.getHeight())/2), canvas);
				break;
			case 2:
				drawCarTatto2(((devWidth-carTatto2.getWidth())/2), ((devHeight-carTatto2.getHeight())/2), canvas);
				break;
			case 3:
				drawCarTatto3(((devWidth-carTatto3.getWidth())/2), ((devHeight-carTatto3.getHeight())/2), canvas);
				break;
			case 4:
				drawCarTatto4(((devWidth-carTatto4.getWidth())/2), ((devHeight-carTatto4.getHeight())/2), canvas);
				break;
			case 5:
				drawCarTatto5(((devWidth-carTatto5.getWidth())/2), ((devHeight-carTatto5.getHeight())/2), canvas);
				break;
			case 6:
				drawCarTatto6(((devWidth-carTatto6.getWidth())/2), ((devHeight-carTatto6.getHeight())/2), canvas);
				break;
			case 7:
				drawCarTatto7(((devWidth-carTatto7.getWidth())/2), ((devHeight-carTatto7.getHeight())/2), canvas);
				break;
			case 8:
				drawCarTatto8(((devWidth-carTatto8.getWidth())/2), ((devHeight-carTatto8.getHeight())/2), canvas);
				break;
			case 9:
				drawCarTatto9(((devWidth-carTatto9.getWidth())/2), ((devHeight-carTatto9.getHeight())/2), canvas);
				break;
			case 10:
				drawCarTatto10(((devWidth-carTatto10.getWidth())/2), ((devHeight-carTatto10.getHeight())/2), canvas);
				break;
			default:
				break;
			}
			
			//Selecting Strip
			switch (selectedCarStrip) {
			case 1:
				drawCarStrip1(((devWidth-carStrip1.getWidth())/2), ((devHeight-carStrip1.getHeight())/2), canvas);
				break;
			case 2:
				drawCarStrip2(((devWidth-carStrip2.getWidth())/2), ((devHeight-carStrip2.getHeight())/2), canvas);
				break;
			case 3:
				drawCarStrip3(((devWidth-carStrip3.getWidth())/2), ((devHeight-carStrip3.getHeight())/2), canvas);
				break;
			case 4:
				drawCarStrip4(((devWidth-carStrip4.getWidth())/2), ((devHeight-carStrip4.getHeight())/2), canvas);
				break;
			default:
				break;
			}
			
			
			
			setOnTouchListener(new View.OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					
					switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						touch_x=event.getX();
						touch_y=event.getY();
						break;
					default:
						break;
					}
					
					if (touch_y>=devHeight-retry.getHeight())  {
						//Play
						screenControler=-1;
						isGameover=0;
					}
					
					
					else if (touch_x>=devWidth-next.getWidth() && touch_x<=devWidth && touch_y>=devUnitHeight*15 && touch_y<=(devUnitHeight*15)+next.getHeight())  {
						//Play
						if(selectedCarBody<16) {
							selectedCarBody++;
						}
						else {
							selectedCarBody=1;
						}
					}
					else if (touch_x>=devWidth-next.getWidth() && touch_x<=devWidth && touch_y>=devUnitHeight*35 && touch_y<=(devUnitHeight*35)+next.getHeight())  {
						//Play
						if(selectedCarGlass<18) {
							selectedCarGlass++;
						}
						else {
							selectedCarGlass=1;
						}
					}
					else if (touch_x>=devWidth-next.getWidth() && touch_x<=devWidth && touch_y>=devUnitHeight*55 && touch_y<=(devUnitHeight*55)+next.getHeight())  {
						//Play
						if(selectedCarTatto<10) {
							selectedCarTatto++;
						}
						else {
							selectedCarTatto=0;
						}
					}
					else if (touch_x>=devWidth-next.getWidth() && touch_x<=devWidth && touch_y>=devUnitHeight*75 && touch_y<=(devUnitHeight*75)+next.getHeight())  {
						//Play
						if(selectedCarStrip<4) {
							selectedCarStrip++;
						}
						else {
							selectedCarStrip=1;
						}
					}
					
					
					else if (touch_x>=0 && touch_x<=previous.getWidth() && touch_y>=devUnitHeight*15 && touch_y<=(devUnitHeight*15)+next.getHeight())  {
						//Play
						if(selectedCarBody>1) {
							selectedCarBody--;
						}
						else {
							selectedCarBody=16;
						}
					}else if (touch_x>=0 && touch_x<=previous.getWidth() && touch_y>=devUnitHeight*35 && touch_y<=(devUnitHeight*35)+next.getHeight())  {
						//Play
						if(selectedCarGlass>1) {
							selectedCarGlass--;
						}
						else {
							selectedCarGlass=18;
						}
					}else if (touch_x>=0 && touch_x<=previous.getWidth() && touch_y>=devUnitHeight*55 && touch_y<=(devUnitHeight*55)+next.getHeight())  {
						//Play
						if(selectedCarTatto>1) {
							selectedCarTatto--;
						}
						else {
							selectedCarTatto=10;
						}
					}
					else if (touch_x>=0 && touch_x<=previous.getWidth() && touch_y>=devUnitHeight*75 && touch_y<=(devUnitHeight*75)+next.getHeight())  {
						//Play
						if(selectedCarStrip>1) {
							selectedCarStrip--;
						}
						else {
							selectedCarStrip=4;
						}
					}
					else if (touch_x>=((devWidth-carShadow.getWidth())/2) && touch_x<=((devWidth-carShadow.getWidth())/2)+carShadow.getWidth() && touch_y>=((devHeight-carShadow.getHeight())/2) && touch_y<=((devHeight-carShadow.getHeight())/2)+carShadow.getHeight())  {
						
						if(selectedCarStrip>1) {
							selectedCarStrip--;
						}
						else {
							selectedCarStrip=4;
						}
						if(selectedCarTatto>0) {
							selectedCarTatto--;
						}
						else {
							selectedCarTatto=10;
						}
						if(selectedCarGlass>1) {
							selectedCarGlass--;
						}
						else {
							selectedCarGlass=18;
						}
						if(selectedCarBody>1) {
							selectedCarBody--;
						}
						else {
							selectedCarBody=16;
						}
					}
					
					return false;
				}
			});
			
			break;
			
			
		default:
			break;
		}
		
		invalidate();
		
	}

	
	private void drawLaneLine(float x, float y, Canvas canvas) {
		canvas.drawBitmap(laneLine, x, y, paint);
	}
	
	private void drawGrass(float x, float y, Canvas canvas) {
		canvas.drawBitmap(grass, x, y, paint);
	}

	private void drawObsCar1(float x, float y, Canvas canvas) {
		canvas.drawBitmap(obsCar1, x, y, paint);
	}

	private void drawObsCar2(float x, float y, Canvas canvas) {
		canvas.drawBitmap(obsCar2, x, y, paint);
	}

	private void drawObsCar3(float x, float y, Canvas canvas) {
		canvas.drawBitmap(obsCar3, x, y, paint);
	}

	private void drawObsCar4(float x, float y, Canvas canvas) {
		canvas.drawBitmap(obsCar4, x, y, paint);
	}

	private void drawStart(float x, float y, Canvas canvas) {
		canvas.drawBitmap(start, x, y, paint);
	}

	private void drawCr(float x, float y, Canvas canvas) {
		canvas.drawBitmap(cr, x, y, paint);
	}

	private void drawAsh(float x, float y, Canvas canvas) {
		canvas.drawBitmap(ash, x, y, paint);
	}

	private void drawOver(float x, float y, Canvas canvas) {
		canvas.drawBitmap(over, x, y, paint);
	}

	private void drawGame(float x, float y, Canvas canvas) {
		canvas.drawBitmap(game, x, y, paint);
	}

	private void drawPlayIcon(float x, float y, Canvas canvas) {
		canvas.drawBitmap(playIcon, x, y, paint);
	}

	private void drawGarageIcon(float x, float y, Canvas canvas) {
		canvas.drawBitmap(garageIcon, x, y, paint);
	}

	private void drawHowToPlayIcon(float x, float y, Canvas canvas) {
		canvas.drawBitmap(howToPlayIcon, x, y, paint);
	}

	private void drawHowToPlay(float x, float y, Canvas canvas) {
		canvas.drawBitmap(howToPlay, x, y, paint);
	}

	private void drawAboutUsIcon(float x, float y, Canvas canvas) {
		canvas.drawBitmap(aboutUsIcon, x, y, paint);
	}

	private void drawAboutUs(float x, float y, Canvas canvas) {
		canvas.drawBitmap(aboutUs, x, y, paint);
	}

	private void drawExitIcon(float x, float y, Canvas canvas) {
		canvas.drawBitmap(exitIcon, x, y, paint);
	}

	private void drawScore(float x, float y, Canvas canvas) {
		canvas.drawBitmap(score, x, y, paint);
	}

	private void drawMainMenu(float x, float y, Canvas canvas) {
		canvas.drawBitmap(mainMenu, x, y, paint);
	}

	private void drawRetry(float x, float y, Canvas canvas) {
		canvas.drawBitmap(retry, x, y, paint);
	}

	private void drawLoading(float x, float y, Canvas canvas) {
		canvas.drawBitmap(loading, x, y, paint);
	}

	private void drawNext(float x, float y, Canvas canvas) {
		canvas.drawBitmap(next, x, y, paint);
	}

	private void drawPrevious(float x, float y, Canvas canvas) {
		canvas.drawBitmap(previous, x, y, paint);
	}

	private void drawSelect(float x, float y, Canvas canvas) {
		canvas.drawBitmap(select, x, y, paint);
	}

	private void drawHighScore(float x, float y, Canvas canvas) {
		canvas.drawBitmap(highScore, x, y, paint);
	}

	
	//drawing Numbers
	private void drawOne(float x, float y, Canvas canvas) {
		canvas.drawBitmap(one, x, y, paint);
	}
	
	private void drawTwo(float x, float y, Canvas canvas) {
		canvas.drawBitmap(two, x, y, paint);
	}

	private void drawThree(float x, float y, Canvas canvas) {
		canvas.drawBitmap(three, x, y, paint);
	}

	private void drawFour(float x, float y, Canvas canvas) {
		canvas.drawBitmap(four, x, y, paint);
	}

	private void drawFive(float x, float y, Canvas canvas) {
		canvas.drawBitmap(five, x, y, paint);
	}

	private void drawSix(float x, float y, Canvas canvas) {
		canvas.drawBitmap(six, x, y, paint);
	}

	private void drawSeven(float x, float y, Canvas canvas) {
		canvas.drawBitmap(seven, x, y, paint);
	}

	private void drawEight(float x, float y, Canvas canvas) {
		canvas.drawBitmap(eight, x, y, paint);
	}

	private void drawNine(float x, float y, Canvas canvas) {
		canvas.drawBitmap(nine, x, y, paint);
	}

	private void drawZero(float x, float y, Canvas canvas) {
		canvas.drawBitmap(zero, x, y, paint);
	}

	
	private void drawPlatform(float x, float y, Canvas canvas) {
		canvas.drawBitmap(platform, x, y, paint);
	}
	private void drawBlast(float x, float y, Canvas canvas) {
		canvas.drawBitmap(blast, x, y, paint);
	}
	private void drawCarShadow(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carShadow, x, y, paint);
	}

	//drawing car body
	private void drawCarBody1(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody1, x, y, paint);
	}
	private void drawCarBody2(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody2, x, y, paint);
	}
	private void drawCarBody3(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody3, x, y, paint);
	}
	private void drawCarBody4(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody4, x, y, paint);
	}
	private void drawCarBody5(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody5, x, y, paint);
	}
	private void drawCarBody6(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody6, x, y, paint);
	}
	private void drawCarBody7(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody7, x, y, paint);
	}
	private void drawCarBody8(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody8, x, y, paint);
	}
	private void drawCarBody9(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody9, x, y, paint);
	}
	private void drawCarBody10(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody10, x, y, paint);
	}
	private void drawCarBody11(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody11, x, y, paint);
	}
	private void drawCarBody12(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody12, x, y, paint);
	}
	private void drawCarBody13(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody13, x, y, paint);
	}
	private void drawCarBody14(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody14, x, y, paint);
	}
	private void drawCarBody15(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody15, x, y, paint);
	}
	private void drawCarBody16(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carBody16, x, y, paint);
	}
	
	//drawing car Glass
	private void drawCarGlass1(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass1, x, y, paint);
	}
	private void drawCarGlass2(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass2, x, y, paint);
	}
	private void drawCarGlass3(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass3, x, y, paint);
	}
	private void drawCarGlass4(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass4, x, y, paint);
	}
	private void drawCarGlass5(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass5, x, y, paint);
	}
	private void drawCarGlass6(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass6, x, y, paint);
	}
	private void drawCarGlass7(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass7, x, y, paint);
	}
	private void drawCarGlass8(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass8, x, y, paint);
	}
	private void drawCarGlass9(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass9, x, y, paint);
	}
	private void drawCarGlass10(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass10, x, y, paint);
	}
	private void drawCarGlass11(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass11, x, y, paint);
	}
	private void drawCarGlass12(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass12, x, y, paint);
	}
	private void drawCarGlass13(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass13, x, y, paint);
	}
	private void drawCarGlass14(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass14, x, y, paint);
	}
	private void drawCarGlass15(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass15, x, y, paint);
	}
	private void drawCarGlass16(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass16, x, y, paint);
	}
	private void drawCarGlass17(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass17, x, y, paint);
	}
	private void drawCarGlass18(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carGlass18, x, y, paint);
	}
	
	//drawing car Tatto
	private void drawCarTatto1(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carTatto1, x, y, paint);
	}
	private void drawCarTatto2(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carTatto2, x, y, paint);
	}
	private void drawCarTatto3(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carTatto3, x, y, paint);
	}
	private void drawCarTatto4(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carTatto4, x, y, paint);
	}
	private void drawCarTatto5(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carTatto5, x, y, paint);
	}
	private void drawCarTatto6(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carTatto6, x, y, paint);
	}
	private void drawCarTatto7(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carTatto7, x, y, paint);
	}
	private void drawCarTatto8(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carTatto8, x, y, paint);
	}
	private void drawCarTatto9(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carTatto9, x, y, paint);
	}
	private void drawCarTatto10(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carTatto10, x, y, paint);
	}

	//drawing car Strip
	private void drawCarStrip1(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carStrip1, x, y, paint);
	}
	private void drawCarStrip2(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carStrip2, x, y, paint);
	}
	private void drawCarStrip3(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carStrip3, x, y, paint);
	}
	private void drawCarStrip4(float x, float y, Canvas canvas) {
		canvas.drawBitmap(carStrip4, x, y, paint);
	}
	
	//Drawing Other Stuff
	private void drawTree(float x, float y, Canvas canvas) {
		canvas.drawBitmap(tree, x, y, paint);
	}
	private void drawGlassBlue(float x, float y, Canvas canvas) {
		canvas.drawBitmap(glassBlue, x, y, paint);
	}
	private void drawGlassRed(float x, float y, Canvas canvas) {
		canvas.drawBitmap(glassRed, x, y, paint);
	}
	private void drawInstruction1(float x, float y, Canvas canvas) {
		canvas.drawBitmap(instruction1, x, y, paint);
	}
	private void drawInstruction2(float x, float y, Canvas canvas) {
		canvas.drawBitmap(instruction2, x, y, paint);
	}
	private void drawInstruction3(float x, float y, Canvas canvas) {
		canvas.drawBitmap(instruction3, x, y, paint);
	}
	private void drawInstruction4(float x, float y, Canvas canvas) {
		canvas.drawBitmap(instruction4, x, y, paint);
	}
	
}
