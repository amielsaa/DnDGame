package Backend.Utils;

import Backend.Callbacks.VisibilityCallBack;

public class TrapResource extends Resource {
    public int visibleTime;
    public int invisbleTime;
    public boolean visible;
    private int ticksCount;
    public VisibilityCallBack visibilityCallBack;

    public TrapResource(int healthCapacity, int visibleTime, int invisibleTime, VisibilityCallBack v){
        super(healthCapacity,healthCapacity);
        this.visibleTime = visibleTime;
        this.invisbleTime = invisibleTime;
        visible = true;
        ticksCount = 0;
        //this.visibilityCallBack = v;

    }
    public void visibilityOnTick()
    {
        visible = ticksCount<visibleTime;
        //visibilityCallBack.call(visible);
        if(ticksCount==(visibleTime+invisbleTime))
            ticksCount=0;
        else
            ticksCount = ticksCount+1;
    }
}
