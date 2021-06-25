package Backend.Utils;

import Backend.Callbacks.VisibilityCallBack;

public class TrapResource extends Resource {
    public int visibleTime;
    public int invisbleTime;
    public boolean visible;
    private int ticksCount;
    public VisibilityCallBack visibilityCallBack;

    public TrapResource(int healthCapacity, int visableTime, int invisbleTime, VisibilityCallBack v){
        super(healthCapacity,healthCapacity);
        this.visibleTime = visableTime;
        this.invisbleTime = invisbleTime;
        visible = true;
        ticksCount = 0;
        this.visibilityCallBack = v;

    }
    public void visibilityOnTick()
    {
        visible = ticksCount<visibleTime;
        visibilityCallBack.call(visible);
        if(ticksCount==(visibleTime+invisbleTime))
            ticksCount=0;
        else
            ticksCount = ticksCount+1;
    }
}
