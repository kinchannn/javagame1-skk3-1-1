import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;

/**
 * コントロールクラス
 * <pre>
 * 当クラスで全体的な制御を行います。
 * </pre>
 */
public class KCtrlSKK extends KCtrl implements KConstant {

	/** フェーズ */
	public static final int			PHASE_INIT			= 0;
	public static final int			PHASE_TITLE			= 1;
	public static final int			PHASE_START			= 2;
	public static final int			PHASE_RUN			= 3;
	public static final int			PHASE_STAGE_CLEAR	= 4;
	public static final int			PHASE_BOMB			= 5;
	public static final int			PHASE_END			= 6;
	public static final int			PHASE_STOP			= -1;

	/** パネル */
	private		KPanel				panel				= null;

	/**
	 * スプライト
	 * <pre>
	 * 全体的に表示等されるスプライトは、ここで管理します。
	 * </pre>
	 */
	private		KSpriteBackground	spriteBackground0	= null;
	private		KSpriteBackground	spriteBackground1	= null;
	private		KSpriteTitle		spriteTitle			= null;
	private		KSpriteShip			spriteShip			= null;
	private		KSpriteShipMini		spriteShipMini		= null;

	/** テキスト */
	private		KText				kTextStart			= null;
	private		KText				kTextSetumei		= null;
	private		KText				kTextBy				= null;
	private		KText				kTextEnd			= null;
	private		KText				kTextScoreHigh		= null;
	private		KText				kTextScore			= null;
	private		KTextShield			kTextShield			= null;
	private		KText				kTextStage			= null;
	private		KText				kTextTime			= null;
	private		KText				kTextBonus			= null;

	/** フェーズ */
	private		int					phase				= PHASE_INIT;

	/** ストーリー */
	private		KStorySKK			kStorySKK			= null;

	/** スコア */
	private		int					score				= 0;

	/** ハイスコア */
	private		int					scoreHigh			= 50000;

	/** ステージ */
	private		int					stage				= 1;

	/** 時間（ワーク用） */
	private		int					timeWork			= 0;

	/** 防御 */
	private		int					shield				= 5;
	/** 防御 */
	private		String				strShield			= "■■■■■";

	/** Qキー押下フラグ */
	private		boolean				flgQ				= false;

	/** Pause制御フラグ */
	private		boolean				flgPause			= false;

	/** 撃墜してからの時間 */
	private		int					timeBomb			= 0;

	/** BGM */
	private		KSoundMidi[]		midiStages			= null;
	private		KSoundMidi			midiStage			= null;
	private		KSoundMidi			midiBoss			= null;

	/** 効果音 */
	private		KSoundWave			waveTitle			= null;
	private		KSoundWave			waveAlpha			= null;
	private		KSoundWave			waveCredit			= null;
	private		KSoundWave[]		waveShots			= null;
	private		KSoundWave[]		waveTekiTaerus		= null;
	private		KSoundWave[]		waveTekiBombs		= null;
	private		KSoundWave[]		waveJimenTaerus		= null;
	private		KSoundWave[]		waveJimenBombs		= null;
	private		KSoundWave[]		waveT08Imbibe		= null;
	private		KSoundWave			waveCollision		= null;
	private		KSoundWave			waveBomb			= null;
	private		KSoundWave			waveItemGet			= null;
	private		KSoundWave			waveAppearSYATIHOKO	= null;
	private		KSoundWave			waveBombSYATIHOKO	= null;
	private		KSoundWave			waveT31Laser		= null;
	private		KSoundWave			waveT34Laser		= null;
	private		KSoundWave			waveBossWarning		= null;
	private		KSoundWave			waveStageClear		= null;
	private		KSoundWave			waveAllClear		= null;
	private		KSoundWave			wavePinch			= null;
	private		KSoundWave			waveGameOver		= null;

	/** ビーム音制御 */
	private		int					posWaveShot			= 0;
	/** 敵耐える制御 */
	private		int					posWaveTekiTaeru	= 0;
	/** 敵爆発音制御 */
	private		int					posWaveTekiBomb		= 0;
	/** 地面耐える制御 */
	private		int					posWaveJimenTaeru	= 0;
	/** 地面爆発音制御 */
	private		int					posWaveJimenBomb	= 0;
	/** T08吸い込み制御 */
	private		int					posWaveT08Imbibe	= 0;

	/** シャチホコ出現フラグ */
	private		boolean				flgBombSYATIHOKO	= false;

	/**
	 * コンストラクタ
	 * @param con コンテナ
	 */
	public KCtrlSKK(Container con){

		super(con);

		try{

			// パネルを生成
			panel = new KPanel(this);

			// 背景色を設定
			panel.setBackground(Color.black);

			// 伸縮モードを設定
			panel.setStretchScreen(true);

			// スプライト層の数を設定
			panel.setLayoutCount(LAYOUT_COUNT);

			// ストーリークラスを生成
			kStorySKK = new KStorySKK(panel);

			// イメージをスプライトに登録する
			KSpriteBackground.initImage();
			KSpriteTitle.initImage();
			KSpriteShip.initImage();
			KSpriteShipMini.initImage();
			KSpriteBeam1.initImage();
			KSpriteS01.initImage();
			KSpriteS02.initImage();
			KSpriteS03.initImage();
			KSpriteS04.initImage();
			KSpriteT00.initImage();
			KSpriteT01.initImage();
			KSpriteT02.initImage();
			KSpriteT03.initImage();
			KSpriteT04.initImage();
			KSpriteT05.initImage();
			KSpriteT06.initImage();
			KSpriteT07.initImage();
			KSpriteT08.initImage();
			KSpriteT09.initImage();
			KSpriteT11.initImage();
			KSpriteT12.initImage();
			KSpriteT13.initImage();
			KSpriteT31.initImage();
			KSpriteT32.initImage();
			KSpriteT33.initImage();
			KSpriteT34.initImage();
			KSpriteT42.initImage();
			KSpriteT43.initImage();
			KSpriteT99.initImage();
			KSpriteT9A.initImage();
			KSpriteT9B.initImage();
			KSpriteJ01.initImage();
			KSpriteJ02.initImage();
			KSpriteJ03.initImage();
			KSpriteJ04.initImage();
			KSpriteJ31.initImage();
			KSpriteJ41.initImage();
			KSpriteJ42.initImage();
			KSpriteJ80.initImage();
			KSpriteJ81.initImage();
			KSpriteG01.initImage();
			KSpriteG11.initImage();
			KSpriteG31.initImage();
			KSpriteG37.initImage();
			KSpriteG38.initImage();
			KSpriteG41.initImage();
			KSpriteG51.initImage();
			KSpriteG61.initImage();
			KSpriteG62.initImage();
			KSpriteG64.initImage();
			KSpriteG71.initImage();

			// スプライト生成
			spriteBackground0 = new KSpriteBackground(panel);
			spriteBackground1 = new KSpriteBackground(panel);
			spriteTitle = new KSpriteTitle(panel);
			spriteShip = new KSpriteShip(panel);
			spriteShipMini = new KSpriteShipMini(panel);

			// 背景を登録
			panel.addSprite(LAYOUT_BACKGROUND, spriteBackground0);
			panel.addSprite(LAYOUT_BACKGROUND, spriteBackground1);

			// 各テキストを生成
			kTextStart = new KText(panel, 215, 400);
			kTextStart.setFont(new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 16));
			kTextStart.setText("PUSH SPACE KEY");

			kTextSetumei = new KText(panel, 144, 460);
			kTextSetumei.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 12));
			kTextSetumei.setText("Q - PAUSE    A - BEAM ON / OFF    Z - BEAM SHOT");

			kTextBy = new KText(panel, 168, 520);
			kTextBy.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 12));
			kTextBy.setText("PROGRAMED  BY  KIN  /  MUSIC  BY  Aki2");

			kTextEnd = new KText(panel, 250, 300);
			kTextEnd.setFont(new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 16));
			kTextEnd.setText("GAME OVER");

			kTextScoreHigh = new KText(panel, 50, 20);
			panel.addText("HIGH-SCORE", kTextScoreHigh);

			kTextScore = new KText(panel, 200, 20);
			panel.addText("SCORE", kTextScore);

			kTextShield = new KTextShield(panel, 350, 20);
			panel.addText("SHIP", kTextShield);

			kTextStage = new KText(panel, 500, 20);
			panel.addText("STAGE", kTextStage);

			kTextTime = new KText(panel, 500, 40);
			panel.addText("TIME", kTextTime);

			kTextBonus = new KText(panel, 200, 300);
			kTextBonus.setFont(new Font("HG丸ｺﾞｼｯｸM-PRO", Font.PLAIN, 16));
			kTextBonus.setText("SYATIHOKO BONUS 100,000");

			// 残機スプライトの設定
			spriteShipMini.setX(320);
			spriteShipMini.setY(4);

			// 背景に切れ目ができないように設定
			spriteBackground1.setY(-600);

			// 効果音を生成
			waveTitle = new KSoundWave(this, "sound/SKK_Title.wav", false);
			waveAlpha = new KSoundWave(this, "sound/SKK_Alpha.wav", false);
			waveCredit = new KSoundWave(this, "sound/SKK_Credit.wav", false);
			waveShots = new KSoundWave[10];
			for(int i = 0; i < 10; i++){
				waveShots[i] = new KSoundWave(this, "sound/SKK_Shot.wav", false);
			}
			waveTekiTaerus = new KSoundWave[8];
			for(int i = 0; i < 8; i++){
				waveTekiTaerus[i] = new KSoundWave(this, "sound/SKK_TekiTaeru.wav", false);
			}
			waveTekiBombs = new KSoundWave[8];
			for(int i = 0; i < 8; i++){
				waveTekiBombs[i] = new KSoundWave(this, "sound/SKK_TekiBomb.wav", false);
			}
			waveJimenTaerus = new KSoundWave[8];
			for(int i = 0; i < 8; i++){
				waveJimenTaerus[i] = new KSoundWave(this, "sound/SKK_JimenTaeru.wav", false);
			}
			waveJimenBombs = new KSoundWave[8];
			for(int i = 0; i < 8; i++){
				waveJimenBombs[i] = new KSoundWave(this, "sound/SKK_JimenBomb.wav", false);
			}
			waveT08Imbibe = new KSoundWave[8];
			for(int i = 0; i < 8; i++){
				waveT08Imbibe[i] = new KSoundWave(this, "sound/SKK_T08Imbibe.wav", false);
			}
			waveCollision = new KSoundWave(this, "sound/SKK_Collision.wav", false);
			waveBomb = new KSoundWave(this, "sound/SKK_Bomb.wav", false);
			waveItemGet = new KSoundWave(this, "sound/SKK_ItemGet.wav", false);
			waveAppearSYATIHOKO = new KSoundWave(this, "sound/SKK_AppearSYATIHOKO.wav", false);
			waveBombSYATIHOKO = new KSoundWave(this, "sound/SKK_BombSYATIHOKO.wav", false);
			waveT31Laser = new KSoundWave(this, "sound/SKK_T31Laser.wav", false);
			waveT34Laser = new KSoundWave(this, "sound/SKK_T34Laser.wav", false);
			waveBossWarning = new KSoundWave(this, "sound/SKK_BossWarning.wav", false);
			waveStageClear = new KSoundWave(this, "sound/SKK_StageClear.wav", false);
			waveAllClear = new KSoundWave(this, "sound/SKK_AllClear.wav", false);
			wavePinch = new KSoundWave(this, "sound/SKK_Pinch.wav", true);
			waveGameOver = new KSoundWave(this, "sound/SKK_GameOver.wav", false);

			// BGMを生成
			midiStages = new KSoundMidi[6];
			midiStages[0] = new KSoundMidi(this, "sound/SKK_Stage1.mid", true);
			midiStages[1] = new KSoundMidi(this, "sound/SKK_Stage2.mid", true);
			midiStages[2] = new KSoundMidi(this, "sound/SKK_Stage3.mid", true);
			midiStages[3] = new KSoundMidi(this, "sound/SKK_Stage4.mid", true);
			midiStages[4] = new KSoundMidi(this, "sound/SKK_Stage5.mid", true);
			midiStages[5] = new KSoundMidi(this, "sound/SKK_Stage6.mid", true);
			midiBoss = new KSoundMidi(this, "sound/SKK_Boss.mid", true);

		// エラーの場合、
		}catch(Exception ex){
			// スタックトレース出力
			ex.printStackTrace();
			// エラーを表示
			JOptionPane.showMessageDialog(null, ex.toString());
		}

	} // end KCtrlSKK

	/**
	 * 開始
	 * <pre>
	 * 当オブジェクトの処理を開始します。
	 * <pre>
	 */
	public void start(){

		// パネルにフォーカスを当てる
		panel.requestFocus();

		EventQueue.invokeLater(new Runnable(){

			public void run(){

				// パネルを開始する
				panel.start();

				// 初期化フェーズへ
				KCtrlSKK.this.phase = PHASE_INIT;

			}

		});

	} // end start

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * </pre>
	 * @return  true：正常 ／ false：一時停止
	 */
	public boolean run(){

		// フェーズ分け
		switch(this.phase){

			// 初期化フェーズ
			case PHASE_INIT:

				// BGMを初期化
				for(int i = 0; i < midiStages.length; i++){
					midiStages[i].init();
				}
				midiBoss.init();

				// スコア
				score = 0;

				// ステージ
				stage = 1;

				// 防御
				shield = 5;
				strShield = "■■■■■";

				// 撃墜時間
				timeBomb = 0;

				// シャチホコ出現フラグ
				flgBombSYATIHOKO = false;

				// ストーリをリセット
				kStorySKK.reset();

				// 自機のスプライト層を初期化
				panel.initKSpriteLstInLayout(LAYOUT_JIBUN);

				// 地面のスプライト層を初期化
				panel.initKSpriteLstInLayout(LAYOUT_JIMEN_0);

				// 地面のスプライト層を初期化
				panel.initKSpriteLstInLayout(LAYOUT_JIMEN_1);

				// 敵のスプライト層を初期化
				panel.initKSpriteLstInLayout(LAYOUT_TEKI);

				// スプライトグループ初期化
				panel.initSpriteGroup();

				// 背景を初期化
				spriteBackground0.setImage(0);
				spriteBackground1.setImage(0);

				// タイトル表示
				panel.addSprite(LAYOUT_JIMEN_0, spriteTitle);
				panel.addText("START", kTextStart);
				panel.addText("BY", kTextBy);
				panel.addText("SETUMEI", kTextSetumei);

				// スコア初期化
				kTextScore.setText("SCORE : " + Integer.toString(score));

				// 効果音をスタート
				waveTitle.start();

				// タイトル画面フェーズへ
				this.phase = PHASE_TITLE;

				break;

			// タイトル画面フェーズ
			case PHASE_TITLE:

				// ハイスコア設定
				kTextScoreHigh.setText("HIGH-SCORE : " + Integer.toString(scoreHigh));

				// スペースが押された場合、
				if(panel.isKeyCodePressed(KeyEvent.VK_SPACE)){

					// タイトルを削除
					panel.removeSprite(LAYOUT_JIMEN_0, spriteTitle);
					panel.removeText("START");
					panel.removeText("BY");
					panel.removeText("SETUMEI");

					// 時間を初期化
					timeWork = 0;

					// 効果音をスタート
					waveCredit.start();

					// スタートフェーズへ
					this.phase = PHASE_START;

				}

				break;

			// スタートフェーズ
			case PHASE_START:

				// 時間＋１
				timeWork++;

				// 1.5秒経ったら、
				if(timeWork > 90){

					// 自機を生成
					spriteShip = new KSpriteShip(panel);

					// 自機を初期化
					spriteShip.init();

					// 自機スプライトを登録
					panel.addSprite(LAYOUT_JIBUN, spriteShip);
					// 残機スプライトを登録
					panel.addSprite(LAYOUT_JIBUN, spriteShipMini);

					// ストーリーを進める
					kStorySKK.start();

					// BGM取得
					midiStage = midiStages[stage - 1];

					// BGMをスタート
					midiStage.start();

					// 通常フェーズへ
					this.phase = PHASE_RUN;

				}

				break;

			// 通常フェーズ
			case PHASE_RUN:

				// Qキーを押していなかった時に押した時、
				if(panel.isKeyCodePressed(KeyEvent.VK_Q) && !flgQ){
					// ポーズ制御
					this.flgPause = !this.flgPause;
				}

				// Qキー制御
				flgQ = panel.isKeyCodePressed(KeyEvent.VK_Q);

				// ポーズの場合、
				if(flgPause){
					// 一時停止でリターン
					return false;
				}

				//
				// ストーリーを進める
				//
				kStorySKK.next();

				// 各テキストを最新化
				kTextScoreHigh.setText("HIGH-SCORE : " + Integer.toString(scoreHigh));

				kTextScore.setText("SCORE : " + Integer.toString(score));

				kTextTime.setText("TIME : " + kStorySKK.getStoryTime());

				kTextStage.setText("STAGE : " + Integer.toString(stage));

				kTextShield.setText(strShield);

				// シャチホコ出現中の場合、
				if(flgBombSYATIHOKO){

					// 時間＋１
					timeWork++;

					// 4秒
					if(timeWork >= 540){

						// シャチホコ終わり
						flgBombSYATIHOKO = false;

						// ボーナス削除
						panel.removeText("BONUS");

						// BGMスタート
						midiStage.start();

					}

				} // end if シャチホコ出現中の場合

				break;

			// 撃墜フェーズ
			case PHASE_BOMB:

				//
				// ストーリーを進める
				//
				kStorySKK.next();

				// 各テキストを最新化
				kTextTime.setText("TIME : " + kStorySKK.getStoryTime());

				kTextShield.setText(strShield);

				// 撃墜時間を進める
				timeBomb++;

				// 時間が経った場合、
				if(timeBomb > 210){

					// 効果音をスタート
					waveGameOver.start();

					// ゲームオーバーフェーズへ
					phase = PHASE_END;

					panel.addText("END", kTextEnd);

				}

				break;

			// ゲームオーバーフェーズ
			case PHASE_END:

				//
				// ストーリーを進める
				//
				kStorySKK.next();

				// 各テキストを最新化
				kTextTime.setText("TIME : " + kStorySKK.getStoryTime());

				// 撃墜時間を進める
				timeBomb++;

				// 時間が経った場合、
				if(timeBomb > 960){

					panel.removeText("END");

					// GC
					this.gc(true);

					// 初期化フェーズへ
					phase = PHASE_INIT;

				}

				break;

			default:
				break;

		} // end switch フェーズ分け

		// 正常でリターン
		return true;

	} // end run

	/**
	 * スコア加算
	 * <pre>
	 * スコア加算する場合は、呼び出してください。
	 * </pre>
	 * @param scoreAdd 追加する点数
	 */
	public void addScore(int scoreAdd){

		// スコアを加算
		this.score = this.score + scoreAdd;

		// ハイスコアを更新する
		this.scoreHigh = (this.score > this.scoreHigh)?this.score: this.scoreHigh;

		// ハイスコアを最新化
		kTextScoreHigh.setText("HIGH-SCORE : " + Integer.toString(scoreHigh));

		// スコアを最新化
		kTextScore.setText("SCORE : " + Integer.toString(score));

	} // end addScore

	/**
	 * スコア取得
	 * @return int スコア
	 */
	public int getScore(){

		return this.score;

	} // end getScore

	/**
	 * 防御加減算
	 * <pre>
	 * プラスもマイナスも処理します。
	 * 0になったら、ゲームオーバーです。
	 * </pre>
	 * @param shieldAdd 加減算する数
	 * @return 加減算した後の防御数
	 */
	public int addShield(int shieldAdd){

		// 防御加減算
		this.shield = this.shield + shieldAdd;

		StringBuilder sb = new StringBuilder();

		// 防御テキストを作成しなおす
		for(int i = 0; i < this.shield; i++){
			sb.append("■");
		}

		strShield = sb.toString();

		// ダメージを受けた場合（受けた影響が−１以下の場合）、
		if(shieldAdd < 0){
			// 色を変更する
			kTextShield.damage();
		}

		// 防御が１になった場合、
		if(this.shield == 1){

			// ピンチ音をスタート
			wavePinch.start();

		// 防御が１から２になった場合、
		}else if(this.shield == 2 && shieldAdd == 1){

			// ピンチ音をストップ
			wavePinch.stop();

		// 防御が０になった場合、
		}else if(this.shield == 0){

			// ピンチ音をストップ
			wavePinch.stop();

			// BGMをストップ
			midiStage.stop();

			// 撃墜フェーズへ
			phase = PHASE_BOMB;

		}

		// 加減算した後の防御数をリターン
		return this.shield;

	} // end addScore

	/**
	 * 防御取得
	 * <pre>
	 * </pre>
	 * @return int 防御数
	 */
	public int getShield(){

		return this.shield;

	} // end getShield

	/**
	 * フェーズ再開
	 */
	public void restart(){

		// ゲームオーバー中の場合、
		if(this.phase == PHASE_BOMB || this.phase == PHASE_END){

			// 何もしない

		// 上記以外の場合、
		}else{

			// フェーズ再開
			this.phase = PHASE_RUN;

		}

	}

	/**
	 * フェーズ取得
	 */
	public int getPhase(){

		return phase;

	}

	/**
	 * フェーズ停止
	 */
/*	public void stop(){

		// フェーズ停止
		this.phase = PHASE_STOP;

	}
*/
	/**
	 * ステージ取得
	 */
	public int getStage(){

		// ステージをリターン
		return this.stage;

	}

	/**
	 * ステージ＋１
	 */
	public void addStage(){

		// ステージを＋１
		this.stage++;

		// GC
		this.gc(false);

		// BGM取得
		midiStage = midiStages[stage - 1];

		// BGM演奏位置初期化
		midiStage.init();
		// BGMをスタート
		midiStage.start();

		// STAGE4以外
		if(stage != 4){

			// 背景を設定
			spriteBackground0.setImage(0);
			spriteBackground1.setImage(0);

		// STAGE4
		}else{

			// 背景を設定
			spriteBackground0.setImage(1);
			spriteBackground1.setImage(1);

		} // end if

	} // end addStage

	/**
	 * パネル取得
	 * @return KPanel パネル
	 */
	public KPanel getKPanel(){

		// パネルをリターン
		return this.panel;

	}

	/**
	 * ストーリークラス取得
	 * @return KPanel パネル
	 */
	public KStory getKStory(){

		// パネルをリターン
		return this.kStorySKK;

	}

	/**
	 * ビキーンスタート
	 */
	public void startWaveAlpha(){

		// 効果音をスタート
		waveAlpha.start();

	}

	/**
	 * ビーム音スタート
	 */
	public void startWaveBeam(){

		// ビーム音制御
		posWaveShot = (posWaveShot == 9)?0: ++posWaveShot;

		// 効果音をスタート
		waveShots[posWaveShot].start();

	}

	/**
	 * 敵耐える音スタート
	 */
	public void startWaveTekiTaeru(){

		// 敵爆発音音制御
		posWaveTekiTaeru = (posWaveTekiTaeru == 7)?0: ++posWaveTekiTaeru;

		// 効果音をスタート
		waveTekiTaerus[posWaveTekiTaeru].start();

	}

	/**
	 * 敵爆発音スタート
	 */
	public void startWaveTekiBomb(){

		// 敵爆発音音制御
		posWaveTekiBomb = (posWaveTekiBomb == 7)?0: ++posWaveTekiBomb;

		// 効果音をスタート
		waveTekiBombs[posWaveTekiBomb].start();

	}

	/**
	 * 地上物耐える音スタート
	 */
	public void startWaveJimenTaeru(){

		// 地上物爆発音音制御
		posWaveJimenTaeru = (posWaveJimenTaeru == 7)?0: ++posWaveJimenTaeru;

		// 効果音をスタート
		waveJimenTaerus[posWaveJimenTaeru].start();

	}

	/**
	 * 地上物爆発音スタート
	 */
	public void startWaveJimenBomb(){

		// 地上物爆発音音制御
		posWaveJimenBomb = (posWaveJimenBomb == 7)?0: ++posWaveJimenBomb;

		// 効果音をスタート
		waveJimenBombs[posWaveJimenBomb].start();

	}

	/**
	 * T08吸い込み音スタート
	 */
	public void startWaveT08Imbibe(){

		// 敵爆発音音制御
		posWaveT08Imbibe = (posWaveT08Imbibe == 7)?0: ++posWaveT08Imbibe;

		// 効果音をスタート
		waveT08Imbibe[posWaveT08Imbibe].start();

	}

	/**
	 * 敵接触音スタート
	 */
	public void startWaveCollision(){
		// 効果音をスタート
		waveCollision.start();
	}

	/**
	 * 爆発音スタート
	 */
	public void startWaveBomb(){
		// 効果音をスタート
		waveBomb.start();
	}

	/**
	 * ステージ音ストップ
	 */
	public void stopMidiStage(){

		// BGMをストップ
		midiStage.stop();

	}

	/**
	 * ボス音スタート
	 */
	public void startMidiBoss(){

		// BGMをスタート
		midiBoss.start();

	}

	/**
	 * ボス音ストップ
	 */
	public void stopMidiBoss(){

		// BGMをストップ
		midiBoss.stop();

		// BGMを初期化
		// （ここで初期化しておく）
		midiBoss.init();

		// BGMをスタート
		midiStage.start();

	}

	/**
	 * アイテム取得スタート
	 */
	public void startWaveItemGet(){
		// 効果音をスタート
		waveItemGet.start();
	}

	/**
	 * シャチホコ出現
	 */
	public void appearSYATIHOKO(){
		// 効果音をスタート
		waveAppearSYATIHOKO.start();
	}

	/**
	 * シャチホコ破壊
	 */
	public void bombSYATIHOKO(){

		// シャチホコ破壊
		flgBombSYATIHOKO = true;

		// ボーナス表示
		panel.addText("BONUS", kTextBonus);

		// 時間を初期化
		timeWork = 0;

		// BGMをストップ
		midiStage.stop();

		// 効果音をスタート
		waveBombSYATIHOKO.start();

	} // end bombSYATIHOKO

	/**
	 * レーザーT31
	 */
	public void laserT31(){
		// 効果音をスタート
		waveT31Laser.start();
	}

	/**
	 * レーザーT34
	 */
	public void laserT34(){
		// 効果音をスタート
		waveT34Laser.start();
	}

	/**
	 * ボス警告
	 */
	public void startBossWarning(){
		// 効果音をスタート
		waveBossWarning.start();
	}

	/**
	 * ステージクリア
	 */
	public void stageClear(){

		// BGMをストップ
		midiStage.stop();
		// 効果音をスタート
		waveStageClear.start();

		// ステージクリアフェーズ
		this.phase = PHASE_STAGE_CLEAR;

	}

	/**
	 * オールクリア
	 */
	public void allClear(){

		// 効果音をストップ
		waveStageClear.stop();
		// 効果音をスタート
		waveAllClear.start();

		// フェーズ変更
		phase = PHASE_END;

	}

	/**
	 * ゲームオーバー
	 */
	public void gameover(){

		// BGMをストップ
		midiStage.stop();

		// 効果音をスタート
		waveGameOver.start();

		// フェーズ変更
		phase = PHASE_END;

		panel.addText("END", kTextEnd);

	} // end gameover

	/**
	 * GC
	 * <pre>
	 * GCと、メモリの状態をコンソールに出力します。
	 * </pre>
	 * @param flagGC true：GCを行う ／ false：GCを行わない
	 */
	private void gc(boolean flagGC){

		// GCを行う場合、
		if(flagGC){
			// GC
			System.gc();
		}

		Runtime runtime = Runtime.getRuntime();
		System.out.println((runtime.totalMemory() - runtime.freeMemory()) / 1000 + "KBytes");
		System.out.println("MAX:" + runtime.maxMemory());
	}

}
