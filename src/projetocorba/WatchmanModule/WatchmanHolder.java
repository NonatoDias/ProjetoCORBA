package WatchmanModule;

/**
* WatchmanModule/WatchmanHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from IDLWatchmanModule.idl
* Segunda-feira, 15 de Outubro de 2018 11h36min23s GMT-03:00
*/

public final class WatchmanHolder implements org.omg.CORBA.portable.Streamable
{
  public WatchmanModule.Watchman value = null;

  public WatchmanHolder ()
  {
  }

  public WatchmanHolder (WatchmanModule.Watchman initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WatchmanModule.WatchmanHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WatchmanModule.WatchmanHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WatchmanModule.WatchmanHelper.type ();
  }

}
