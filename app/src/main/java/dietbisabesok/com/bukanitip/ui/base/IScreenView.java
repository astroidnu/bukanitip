package dietbisabesok.com.bukanitip.ui.base;

/**
 * PLEASE FILL IN THE CLASS DESCRIPTION
 *
 * @author zhaocong
 */
public interface IScreenView {

    /**
     * Callback to perform view-based customization
     * <p/>
     * You shall NOT put the logic here and all application logic shall go to the
     * presenter instead of view
     */
    public void onShowView();

    public void onHideView();

    public void onDestroy();
}
