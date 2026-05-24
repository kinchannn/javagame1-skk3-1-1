/**
 * 敵２
 */
public class KSpriteGroupT02 extends KSpriteGroup implements KConstant {

	/** 編隊ポジション */
	private		int			pos			= -1;

	/** ビーム発射位置 */
	private		String		storyParam	= null;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam ビーム発射位置
	 */
	public KSpriteGroupT02(KPanel panel, String storyParam){
		super(panel);
		this.storyParam = storyParam;
	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 30) == 0){
			pos++;
			// スプライトを生成
			KSpriteT02 kSpriteT02 = new KSpriteT02(super.getKPanel(), pos, storyParam);
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT02);
		}

		// 11回出たら、
		if(time == 300){
			// スプライトグループを消す
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
