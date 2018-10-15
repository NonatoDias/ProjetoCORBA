package WatchmanModule;


/**
* WatchmanModule/WatchmanHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from IDLWatchmanModule.idl
* Segunda-feira, 15 de Outubro de 2018 11h36min23s GMT-03:00
*/

abstract public class WatchmanHelper
{
  private static String  _id = "IDL:WatchmanModule/Watchman:1.0";

  public static void insert (org.omg.CORBA.Any a, WatchmanModule.Watchman that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static WatchmanModule.Watchman extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (WatchmanModule.WatchmanHelper.id (), "Watchman");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static WatchmanModule.Watchman read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_WatchmanStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, WatchmanModule.Watchman value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static WatchmanModule.Watchman narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof WatchmanModule.Watchman)
      return (WatchmanModule.Watchman)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      WatchmanModule._WatchmanStub stub = new WatchmanModule._WatchmanStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static WatchmanModule.Watchman unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof WatchmanModule.Watchman)
      return (WatchmanModule.Watchman)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      WatchmanModule._WatchmanStub stub = new WatchmanModule._WatchmanStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}