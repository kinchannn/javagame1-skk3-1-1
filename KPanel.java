import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * パネルクラス
 * <pre>
 * 時間の制御を行い、適宜、スプライトグループ、スプライトを呼び出します。
 * スプライトの描画も行います。
 * キーの押下状態を制御します。
 * </pre>
 */
public class KPanel extends JPanel {

	/** 制御クラス */
	private KCtrl kCtrl = null;

	/** 比率−幅 */
	private float ratioWidth = 1f;
	/** 比率−高さ */
	private float ratioHeight = 1f;

	/** 画面伸縮モード */
	private boolean stretchScreen = false;

	/** フォント */
	private Font fontS = new Font("ＭＳ ゴシック", Font.PLAIN, 11);

	/** スプライトグループ一覧 */
	public ArrayList<KSpriteGroup> kSpriteGroupLst = null;

	/** スプライト層一覧 */
	private ArrayList<ArrayList<KSprite>> kSpriteLayoutLst = null;

	/** スプライト層深さ */
	private int kSpriteLayoutCount = 0;

	/** 文字列一覧 */
	public HashMap<String, KText> kTextLst = null;

	/** キーを押している状態一覧 */
	private boolean[] keyPressTbl = null;

	/** タイマー */
	private java.util.Timer timerThis = null;

	/** 時間 */
	private int time = 0;

	// ゲーム中フラグ
	boolean flgPlaying = true;

	/**
	 * コンストラクタ
	 * @param kCtrl 制御クラス
	 */
	public KPanel(KCtrl kCtrl){

		// スーパークラスを呼び出す
		super();

		// 制御クラス保持
		this.kCtrl = kCtrl;

		// 初期化処理を呼び出す
		init();

	} // end KPanel

	/**
	 * 初期化処理
	 * <pre>
	 * オーバーライドする場合は、必ず一番最初にsuper.init()を呼び出してください。
	 * </pre>
	 */
	public void init(){

		// レイアウト設定
		super.setLayout(null);

		// キー押下状況一覧を生成
		keyPressTbl = new boolean[256];

		// キーイベントを登録
		this.addKeyListener(new KPanelKeyAdapter());

		// コンポーネントイベントを登録
		this.addComponentListener(new KPanelComponentAdapter());

		// スプライトグループ一覧生成
		kSpriteGroupLst = new ArrayList<KSpriteGroup>(100);

		// タイマーを生成
		timerThis = new java.util.Timer();

	} // end init

	/**
	 * スプライト層設定
	 * <pre>
	 * スプライト層の深さの設定をします。
	 * 描画順が保証されます。
	 * </pre>
	 * @param layoutCount スプライト層の深さ
	 */
	public void setLayoutCount(int layoutCount){

		// スプライト層深さを保持
		kSpriteLayoutCount = layoutCount;

		// スプライト層一覧生成
		kSpriteLayoutLst = new ArrayList<ArrayList<KSprite>>(layoutCount);

		// スプライト層分、ループ
		for(int i = 0; i < layoutCount; i++){

			// スプライト一覧を生成
			ArrayList<KSprite> kSpriteLst = new ArrayList<KSprite>(100);

			// スプライト層一覧に追加
			kSpriteLayoutLst.add(kSpriteLst);

		} // end for スプライト層分、ループ

		// 文字列一覧生成
		kTextLst = new HashMap<String, KText>();

	}

	/**
	 * スプライト層初期化
	 * <pre>
	 * スプライト層に登録されているスプライトを削除します。
	 * 元々登録されていた場合には、クリアされます。
	 * </pre>
	 * @param layout 初期化するスプライト層
	 */
	public void initKSpriteLstInLayout(int layout){

		// スプライト一覧を生成
		ArrayList<KSprite> kSpriteLst = new ArrayList<KSprite>(100);

		// スプライト層一覧に設定
		kSpriteLayoutLst.set(layout, kSpriteLst);

	} // end initKSpriteLstInLayout

	/**
	 * スプライトグループ初期化
	 * <pre>
	 * スプライトグループを初期化します。
	 * 元々登録されていた場合には、クリアされます。
	 * </pre>
	 */
	public void initSpriteGroup(){

		// スプライトグループ一覧生成
		this.kSpriteGroupLst = new ArrayList<KSpriteGroup>(100);

	}

	/**
	 * 開始
	 * <pre>
	 * 当オブジェクトの処理を開始します。
	 * タイマーが動き始め、コントロールクラス および 各スプライトオブジェクトの処理が定期的に呼び出されます。
	 * </pre>
	 */
	public void start(){

		// タイマーをスタート
		timerThis.scheduleAtFixedRate(new TimerActionListener(), 1l, 4l);

	}

	/**
	 * 実行
	 */
	public void run(){

		// 時間＋１
		time++;

		// 制御の時間
		if(time % 4 == 0){

			// 制御クラスの実行メソッド呼び出し
			flgPlaying = kCtrl.run();

			// ゲーム中の場合（ポーズ中ではない場合）、
			if(flgPlaying){

				//
				// スプライトグループ処理
				//

				// スプライトグループ一覧の件数を取得
				int countSpriteGroupLst = kSpriteGroupLst.size();

				// スプライトグループ一覧の件数分、ループ
				for(int i = 0; i < countSpriteGroupLst; i++){

					// スプライトグループを取得
					KSpriteGroup spriteGroup = kSpriteGroupLst.get(i);

					// スプライトグループがnull以外の場合、
					if(spriteGroup != null){

						// スプライトグループの時間を進める
						spriteGroup.forward();

						// スプライトグループを実行
						spriteGroup.run();

					}

				} // end for スプライトグループ一覧の件数分、ループ

				// スプライトグループ一覧の件数が100件を超えた場合、
				if(countSpriteGroupLst > 100){

					// スプライトグループ一覧の件数分、ループ
					for(int i = 0; i < countSpriteGroupLst; i++){

						// スプライトグループを取得
						KSpriteGroup spriteGroup = kSpriteGroupLst.get(i);

						// スプライトグループがnullの場合、
						if(spriteGroup == null){

							// スプライトグループをつめる
							kSpriteGroupLst.remove(i);

							// インデックス戻し
							i--;
							countSpriteGroupLst--;

						}

					} // end for スプライトグループ一覧の件数分、ループ

				} // end if スプライトグループ一覧の件数が100件を超えた場合

				//
				// スプライト処理
				//

				// スプライト層深さ分、ループ
				for(int i = 0; i < kSpriteLayoutCount; i++){

					// スプライト一覧を取得
					ArrayList<KSprite> kSpriteLst = (ArrayList<KSprite>)kSpriteLayoutLst.get(i);

					// スプライト一覧の件数を取得
					int kSpriteLstCount = kSpriteLst.size();

					// スプライト一覧の件数分、ループ
					for(int j = 0; j < kSpriteLstCount; j++){

						// スプライトを取得
						KSprite kSprite = (KSprite)kSpriteLst.get(j);

						// スプライトがnull以外の場合、
						if(kSprite != null){

							// スプライトを起動
							kSprite.run();

						}

					} // end for スプライト一覧の件数分、ループ

				} // end for スプライト層深さ分、ループ

				Object[] objKeys = kTextLst.keySet().toArray();

				// 文字列一覧の件数分、ループ
				for(int i = 0; i < objKeys.length; i++){

					// テキスト取得
					KText kText = (KText)kTextLst.get((String)objKeys[i]);

					// テキストがnull以外の場合、
					if(kText != null){

						// 文字列を起動
						kText.run();

					}

				} // end for 文字列一覧の件数分、ループ

			} // end if ゲーム中の場合（ポーズ中ではない場合）

		// お掃除の時間
		}else if(time % 4 == 2){

			// ゲーム中の場合（ポーズ中ではない場合）、
			if(flgPlaying){

				//
				// スプライト一覧が多くなった場合は、お掃除をする。（メモリ増加防止）
				// 上記処理内では行うことができない。
				// スプライト側で自分自身を削除する場合があるため。
				//

				// スプライト層深さ分、ループ
				for(int i = 0; i < kSpriteLayoutCount; i++){

					// スプライト一覧を取得
					ArrayList<KSprite> kSpriteLst = (ArrayList<KSprite>)kSpriteLayoutLst.get(i);

					// スプライト一覧の件数を取得
					int kSpriteLstCount = kSpriteLst.size();

					// スプライト一覧の件数が600件を超えた場合、
					if(kSpriteLstCount > 600){

						// 一時的にスプライト一覧（ワーク）を作成
						ArrayList<KSprite> kSpriteLstWk = new ArrayList<KSprite>(1000);

						// スプライト一覧の件数分、ループ
						for(int j = 0; j < kSpriteLstCount; j++){

							// スプライトを取得
							KSprite kSprite = (KSprite)kSpriteLst.get(j);

							// スプライトがnull以外の場合、
							if(kSprite != null){

								// スプライト一覧（ワーク）に追加
								kSpriteLstWk.add(kSprite);

							}

						} // end for スプライト一覧の件数分、ループ

						// スプライト一覧を入れ替える
						kSpriteLayoutLst.set(i, kSpriteLstWk);

					} // end if スプライト一覧の件数が600件を超えた場合

				} // end for スプライト層深さ分、ループ

			} // end if ゲーム中の場合（ポーズ中ではない場合）

		// 再描画の時間
		}else if(time % 4 == 3){

			// 再描画
			repaint();

		}

	} // end run

	/**
	 * このコンテナ内の各コンポーネントをペイントします。
	 * <pre>
	 * Containerクラスのメソッド継承です。
	 * </pre>
	 */
	public void paintComponent(Graphics g){

		// 自クラスを描画
		super.paintComponent(g);

		// スプライト層深さ分、ループ
		for(int i = 0; i < kSpriteLayoutCount; i++){

			// スプライト一覧を取得
			ArrayList<KSprite> kSpriteLst = (ArrayList<KSprite>)kSpriteLayoutLst.get(i);

			// スプライト一覧の件数分、ループ
			for(int j = 0; j < kSpriteLst.size(); j++){

				// スプライト取得
				KSprite kSprite = kSpriteLst.get(j);

				// スプライトがnull以外の場合、
				if(kSprite != null){
					kSprite.paint(g);
				}
			}

		}

		Object[] objKeys = kTextLst.keySet().toArray();

		// 文字列一覧の件数分、ループ
		for(int i = 0; i < objKeys.length; i++){

			// テキスト取得
			KText kText = (KText)kTextLst.get((String)objKeys[i]);

			// テキストがnull以外の場合、
			if(kText != null){
				// ペイント
				kText.paint(g);
			}
		}

	} // end paintComponent

	/**
	 * スプライトグループ追加
	 * @param spriteGroup スプライト
	 */
	public void addSpriteGroup(KSpriteGroup spriteGroup){

		// スプライトグループを追加
		kSpriteGroupLst.add(spriteGroup);

	} // end addSpriteGroup

	/**
	 * スプライトグループ削除
	 * @param spriteGroup スプライト
	 */
	public void removeSpriteGroup(KSpriteGroup spriteGroup){

		// インデックスを求める
		int index = kSpriteGroupLst.indexOf(spriteGroup);

		// インデックスが取得できた場合、
		if(index != -1){

			// スプライトグループを削除
			kSpriteGroupLst.set(index, null);

		}

	} // end addSpriteGroup

	/**
	 * スプライト追加
	 * @param layout スプライト層
	 * @param kSprite スプライト
	 */
	public void addSprite(int layout, KSprite kSprite){

		// スプライト一覧を取得
		ArrayList<KSprite> kSpriteLst = (ArrayList<KSprite>)kSpriteLayoutLst.get(layout);

		// スプライトを追加
		kSpriteLst.add(kSprite);

	} // end addSprite

	/**
	 * スプライト削除
	 * <pre>
	 * スプライト層から探索して、スプライトを削除します。
	 * </pre>
	 * @param layout スプライト層
	 * @param kSprite スプライト
	 */
	public void removeSprite(int layout, KSprite kSprite){

		// スプライト一覧を取得
		ArrayList<KSprite> kSpriteLst = (ArrayList<KSprite>)kSpriteLayoutLst.get(layout);

		// インデックスを求める
		int index = kSpriteLst.indexOf(kSprite);

		// インデックスが取得できた場合、
		if(index != -1){

			// スプライトを削除
			kSpriteLst.set(index, null);

		}

	} // end addSprite

	/**
	 * スプライト削除
	 * <pre>
	 * 全てのスプライト層を探索して、スプライトを削除します。
	 * 通常はスプライト層が引数として設定しているメソッドを呼んでください。
	 * </pre>
	 * @param kSprite スプライト
	 */
	public void removeSprite(KSprite kSprite){

		// スプライト層深さ分、ループ
		for(int i = 0; i < kSpriteLayoutCount; i++){

			// スプライト削除
			removeSprite(i, kSprite);

		}

	} // end addSprite

	/**
	 * スプライト一覧取得
	 * @param layout スプライト層
	 * @return ArrayList スプライト一覧
	 */
	public ArrayList<KSprite> getSpriteLst(int layout){

		// スプライト一覧を取得
		ArrayList<KSprite> kSpriteLst = (ArrayList<KSprite>)kSpriteLayoutLst.get(layout);

		// リターン
		return kSpriteLst;

	} // end getSpriteLst

	/**
	 * テキスト追加
	 * @param strKey テキストクラスを示す文字列
	 * @param kText テキストクラス
	 */
	public void addText(String strKey, KText kText){

		// 文字列を追加
		kTextLst.put(strKey, kText);

	} // end addText

	/**
	 * テキスト削除
	 * @param strKey テキストクラスを示す文字列
	 */
	public void removeText(String strKey){

		// 文字列を削除
		kTextLst.remove(strKey);

	} // end removeText

	/**
	 * コントロールクラス取得
	 * @return KCtrl コントロールクラス
	 */
	public KCtrl getKCtrl(){

		// コントロールクラスをリターン
		return kCtrl;

	} // end getKCtrl

	/**
	 * 画面伸縮モード取得
	 * <pre>
	 * 画面の伸縮に合わせて、画像も伸縮させるようにするか／しないかを返します。
	 * </pre>
	 * @return boolean true：伸縮させる false：伸縮させない
	 */
	public boolean getStretchScreen(){
		return this.stretchScreen;
	}

	/**
	 * 画面伸縮モード設定
	 * <pre>
	 * 画面の伸縮に合わせて、画像も伸縮させるようにするか、決定します。
	 * </pre>
	 * @param stretchScreen true：伸縮させる false：伸縮させない
	 */
	public void setStretchScreen(boolean stretchScreen){
		this.stretchScreen = stretchScreen;
	}

	/**
	 * 比率−幅 取得
	 * @return float 比率−幅
	 */
	public float getRatioWidth(){
		return ratioWidth;
	}

	/**
	 * 比率−高さ 取得
	 * @return float 比率−高さ
	 */
	public float getRatioHeight(){
		return ratioHeight;
	}

	/**
	 * キー押下中かをどうかをチェック
	 * @param keyCode キーコード
	 * @return boolean true：押している ／ false：押していない
	 */
	public boolean isKeyCodePressed(int keyCode){

		return keyPressTbl[keyCode];

	} // end isKeyCodePressed

	/**
	 * キーアダプタークラス
	 */
	private class KPanelKeyAdapter extends KeyAdapter{

		public void keyPressed(KeyEvent ke){
			int code = ke.getKeyCode();
			if(code < 256){
				keyPressTbl[code] = true;
			}
		}

		public void keyReleased(KeyEvent ke){
			int code = ke.getKeyCode();
			if(code < 256){
				keyPressTbl[code] = false;
			}
		}

	} // KeyAdKPanelKeyAdapterapter

	/**
	 * タイマークラス
	 */
	private class TimerActionListener extends TimerTask {

		public void run(){

			// 実行メソッド呼び出し
			KPanel.this.run();

		} // end actionPerformed

	} // end TimerActionListener

	/**
	 * コンポーネントアダプタークラス
	 */
	private class KPanelComponentAdapter extends ComponentAdapter {

		/**
		 * コンポーネントのサイズ変更イベント
		 */
		@Override
		public void componentResized(ComponentEvent ce){

			// 比率を求める
			ratioWidth = (float)KPanel.this.getWidth() / KConstant.WIDTH;
			ratioHeight = (float)KPanel.this.getHeight() / KConstant.HEIGHT;

		} // end componentResized

	} // end KPanelComponentAdapter

}
