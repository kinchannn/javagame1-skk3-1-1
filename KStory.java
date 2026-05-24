import java.applet.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * ストーリークラス.
 * <pre>
 * 時間を管理し、タイミングが来たら、スプライトオブジェクトを生成します。
 * </pre>
 */
abstract public class KStory {

	/**
	 * パネル.
	 */
	private KPanel panel = null;

	/**
	 * ストーリー時間一覧.
	 */
	public ArrayList<String> timeLst = null;
	/**
	 * ストーリーイベント一覧.
	 */
	public ArrayList<String> eventLst = null;
	/**
	 * ストーリーパラメータ一覧.
	 */
	public ArrayList<String> paramLst = null;

	/**
	 * ストーリー時間.
	 */
	private		int					timeStory			= 0;
	/**
	 * ストーリー次時間.
	 */
	private		int					timeStoryNext		= 0;
	/**
	 * 次イベント.
	 */
	private		String				storyEvent			= null;
	/**
	 * 次パラメータ.
	 */
	private		String				storyParam			= null;

	/**
	 * ストーリーインデックス.
	 */
	private		int					indexStory			= -1;

	/**
	 * 開始フラグ.
	*/
	private		boolean				flgStart			= true;

	/**
	 * コンストラクタ.
	 * @param panel KPanel
	 * @param fileName ファイル名
	 */
	public KStory(KPanel panel, String fileName) throws Exception {

		this.panel = panel;

		timeLst = new ArrayList<String>(100);
		eventLst = new ArrayList<String>(100);
		paramLst = new ArrayList<String>(100);

		// リーダー
		BufferedReader br = null;

		// コンテナを取得
		Container con = panel.getKCtrl().getParent();

		// どうも同じ方法でファイルを取得することができるようだ
		br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));

		// ループ
		while(true){

			// １行読み込む
			String strLine = br.readLine();

			// EOFの場合、
			if(strLine == null){
				// ブレイク
				break;
			}

			// カンマ位置取得
			int index = strLine.indexOf(",");

			// カンマがない場合、
			if(index == -1){
				// エラーで終了
				throw new IllegalStateException("カンマがありません。");
			}

			// ふたつめのカンマ位置取得
			int index2 = strLine.indexOf("," , index + 1);

			String strTime = strLine.substring(0, index);
			String strEvent = null;
			String strParam = null;

			// ふたつめのカンマ位置が取得できなかった場合、
			if(index2 == -1){
				// イベントのみ取得
				strEvent = strLine.substring(index + 1);

			// ふたつめのカンマ位置が取得た場合、
			}else{
				// イベントとパラメータを取得
				strEvent = strLine.substring(index + 1, index2);
				strParam = strLine.substring(index2 + 1);

			} // end if

			// 各一覧に追加
			timeLst.add(strTime);
			eventLst.add(strEvent);
			paramLst.add(strParam);

		} // end while

	} // end KStory

	/**
	 * 現在時間取得.
	 * return int 現在時間（ゲーム内、ストーリー内の時間）
	 */
	public int getStoryTime(){

		return timeStory;

	} // end getTimeStory

	/**
	 * 次のイベント時間取得.
	 * return int 次のイベント時間取得
	 */
	private String getTime(){

		return timeLst.get(indexStory);

	} // end getTime

	/**
	 * イベント取得.
	 * return String イベント
	 */
	private String getEvent(){

		return eventLst.get(indexStory);

	} // end getEvent

	/**
	 * パラメータ取得.
	 * return String パラメータ
	 */
	private String getParam(){

		return paramLst.get(indexStory);

	} // end getParam

	/**
	 * 時間を進める.
	 */
	public void next(){

		// 時間を進める場合、
		if(flgStart){

			// 時間を進める
			this.timeStory++;

			// 次時間になった場合、
			if(this.timeStory >= this.timeStoryNext){

				// ストーリーイベントが存在する場合、
				if(storyEvent != null){

					// スプライトオブジェクト生成
					KSpriteObject spriteObject = storyEvent(storyEvent, storyParam);

					// スプライトの場合、
					if(spriteObject instanceof KSprite){

						// パネルにスプライトを追加
						panel.addSprite(2, (KSprite)spriteObject);

					// スプライトグループの場合、
					}else if(spriteObject instanceof KSpriteGroup){

						// パネルにスプライトグループを追加
						panel.addSpriteGroup((KSpriteGroup)spriteObject);

					} // end if

				} // end if ストーリーイベントが存在する場合

				// ストーリーインデックスを進める
				indexStory++;

				// ストーリーを進める
				timeStoryNext = Integer.parseInt(this.getTime());
				storyEvent = this.getEvent();
				storyParam = this.getParam();

			} // end if 次時間になった場合

		} // end if 時間を進める場合

	} // end next

	/**
	 * パネル取得.
	 */
	public KPanel getKPanel(){
		return panel;
	}

	/**
	 * 開始.
	 */
	public void start(){
		flgStart = true;
	}

	/**
	 * 停止.
	 */
	public void stop(){
		flgStart = false;
	}

	/**
	 * リセット.
	 */
	public void reset(){

		timeStory = 0;
		timeStoryNext = 0;
		indexStory =  -1;

		// ストーリーイベントを消去
		storyEvent = null;
	}

	/**
	 * ストーリー呼び出し.
	 * @param storyEvent イベント
	 * @param storyParam パラメータ
	 * @return スプライトオブジェクト
	 */
	abstract public KSpriteObject storyEvent(String storyEvent, String storyParam);

}
