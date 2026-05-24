/**
 * 地面３６
 */
public class KSpriteGroupJ36 extends KSpriteGroupJ00 implements KConstant {

	private	static final int[][]	JSS			= new int[][]{
		{ 0, J01, 1, J01, 2, J01, 3, J01, 4, J01, 5, J01, 6, J01, 7, J01, 8, J01, 9, J01, 10, J01, 11, J01, 12, J01, 13, J01, 14, J01, 15, J01, 16, J01, 17, J01, 18, J01, 0, G41, 2, G41, 4, G41, 6, G41, 8, G41, 10, G41, 12, G41, 14, G41, 16, G41, 18, G41},
		{ 0, J08, 1, J01, 2, J01, 3, J08, 4, J01, 5, J01, 6, J08, 7, J01, 8, J01, 9, J08, 10, J01, 11, J01, 12, J08, 13, J01, 14, J01, 15, J08, 16, J01, 17, J01, 18, J08, 0, G41, 2, G41, 4, G41, 6, G41, 8, G41, 10, G41, 12, G41, 14, G41, 16, G41, 18, G41},
	};

	private		int				pos				= JSS.length;

	/**
	 * コンストラクタ
	 */
	public KSpriteGroupJ36(KPanel panel, String storyParam){

		super(panel);

		if(storyParam != null){

			int intX = Integer.parseInt(storyParam);

			super.setX(intX);

		}

	}

	/**
	 * 実行メソッド
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 16) == 0){

			// ポジションを変更
			pos--;

			// 地面データを取得
			int[] js = JSS[pos];

			// スプライト配置
			super.haitiSprite(js);

		} // end if 一定時間経過の場合

		// 全て配置したら、
		if(pos <= 0){
			// スプライトグループを削除
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
