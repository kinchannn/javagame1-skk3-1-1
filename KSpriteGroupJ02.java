/**
 * 地面２
 */
public class KSpriteGroupJ02 extends KSpriteGroup implements KConstant {

	private		int			intX			= -1;

	private		int			pos				= -1;

	private		int[][]		mX				= new int[][]{
		{0},
		{-16, 16},
		{-16, 16},
		{-16, 16},
		{-16, 16},
		{-16, 16},
		{-16, 16},
		{-16, 16},
		{-16, 16},
		{-16, 16},
		{0}
	};

	/**
	 * コンストラクタ
	 */
	public KSpriteGroupJ02(KPanel panel, String storyParam){
		super(panel);

		this.intX = Integer.parseInt(storyParam);

	}

	/**
	 * 実行メソッド
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 16) == 0){

			pos++;

			for(int i = 0; i < mX[pos].length; i++){
				KSpriteJ03 kSpriteJ03 = new KSpriteJ03(super.getKPanel(), intX + mX[pos][i]);
				super.getKPanel().addSprite(LAYOUT_JIMEN_0, kSpriteJ03);
			}
		}

		// 10回出たら、
		if(pos >= 10){
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
