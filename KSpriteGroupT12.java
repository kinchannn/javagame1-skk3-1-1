/**
 * 敵１２ 赤い岩
 */
public class KSpriteGroupT12 extends KSpriteGroup implements KConstant {

	/** X移動量 */
	private		String		storyParam	= null;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam パラメータ。未使用。
	 */
	public KSpriteGroupT12(KPanel panel, String storyParam){
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
		if((time % 20) == 0){
			// スプライトを生成
			KSpriteT12 kSpriteT12 = new KSpriteT12(super.getKPanel(), storyParam);
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT12);
		}

		// 30回出たら、
		if(time == 580 ){
			// スプライトグループを消す
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
