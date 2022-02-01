package com.example.yaddahani.roomDB;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.yaddahani.models.FriendsRemindersListModel;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ReminderDao_Impl implements ReminderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FriendsRemindersListModel> __insertionAdapterOfFriendsRemindersListModel;

  private final EntityInsertionAdapter<FriendsRemindersListModel> __insertionAdapterOfFriendsRemindersListModel_1;

  private final SharedSQLiteStatement __preparedStmtOfDeleteReminders;

  private final SharedSQLiteStatement __preparedStmtOfDeleteReminder;

  private final SharedSQLiteStatement __preparedStmtOfReminderArchived;

  public ReminderDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFriendsRemindersListModel = new EntityInsertionAdapter<FriendsRemindersListModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `receivedRemindersTable` (`reminderTableId`,`reminderId`,`reminderText`,`reminderDate`,`reminderFrom`,`reminderTo`,`reminderStatus`,`isExpand`,`isArchived`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FriendsRemindersListModel value) {
        stmt.bindLong(1, value.getReminderTableId());
        stmt.bindLong(2, value.getReminderId());
        if (value.getReminderText() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getReminderText());
        }
        if (value.getReminderDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getReminderDate());
        }
        if (value.getReminderFrom() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getReminderFrom());
        }
        if (value.getReminderTo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReminderTo());
        }
        if (value.getReminderStatus() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getReminderStatus());
        }
        final int _tmp = value.isExpand() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        final int _tmp_1 = value.isArchived() ? 1 : 0;
        stmt.bindLong(9, _tmp_1);
      }
    };
    this.__insertionAdapterOfFriendsRemindersListModel_1 = new EntityInsertionAdapter<FriendsRemindersListModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `receivedRemindersTable` (`reminderTableId`,`reminderId`,`reminderText`,`reminderDate`,`reminderFrom`,`reminderTo`,`reminderStatus`,`isExpand`,`isArchived`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FriendsRemindersListModel value) {
        stmt.bindLong(1, value.getReminderTableId());
        stmt.bindLong(2, value.getReminderId());
        if (value.getReminderText() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getReminderText());
        }
        if (value.getReminderDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getReminderDate());
        }
        if (value.getReminderFrom() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getReminderFrom());
        }
        if (value.getReminderTo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReminderTo());
        }
        if (value.getReminderStatus() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getReminderStatus());
        }
        final int _tmp = value.isExpand() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        final int _tmp_1 = value.isArchived() ? 1 : 0;
        stmt.bindLong(9, _tmp_1);
      }
    };
    this.__preparedStmtOfDeleteReminders = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from receivedRemindersTable";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteReminder = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from receivedRemindersTable where reminderId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfReminderArchived = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update receivedRemindersTable set isArchived = ? where reminderId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object addReminders(final ArrayList<FriendsRemindersListModel> reminders,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFriendsRemindersListModel.insert(reminders);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object addReminder(final FriendsRemindersListModel reminder,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFriendsRemindersListModel_1.insert(reminder);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteReminders(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteReminders.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteReminders.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteReminder(final int deleteReminderId,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteReminder.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, deleteReminderId);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteReminder.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object reminderArchived(final boolean archived, final int id,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfReminderArchived.acquire();
        int _argIndex = 1;
        final int _tmp = archived ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfReminderArchived.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<FriendsRemindersListModel>> getAllReminders() {
    final String _sql = "Select * from receivedRemindersTable order by reminderTableId ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"receivedRemindersTable"}, false, new Callable<List<FriendsRemindersListModel>>() {
      @Override
      public List<FriendsRemindersListModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfReminderTableId = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderTableId");
          final int _cursorIndexOfReminderId = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderId");
          final int _cursorIndexOfReminderText = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderText");
          final int _cursorIndexOfReminderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDate");
          final int _cursorIndexOfReminderFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderFrom");
          final int _cursorIndexOfReminderTo = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderTo");
          final int _cursorIndexOfReminderStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderStatus");
          final int _cursorIndexOfIsExpand = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpand");
          final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
          final List<FriendsRemindersListModel> _result = new ArrayList<FriendsRemindersListModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FriendsRemindersListModel _item;
            final int _tmpReminderTableId;
            _tmpReminderTableId = _cursor.getInt(_cursorIndexOfReminderTableId);
            final int _tmpReminderId;
            _tmpReminderId = _cursor.getInt(_cursorIndexOfReminderId);
            final String _tmpReminderText;
            if (_cursor.isNull(_cursorIndexOfReminderText)) {
              _tmpReminderText = null;
            } else {
              _tmpReminderText = _cursor.getString(_cursorIndexOfReminderText);
            }
            final String _tmpReminderDate;
            if (_cursor.isNull(_cursorIndexOfReminderDate)) {
              _tmpReminderDate = null;
            } else {
              _tmpReminderDate = _cursor.getString(_cursorIndexOfReminderDate);
            }
            final String _tmpReminderFrom;
            if (_cursor.isNull(_cursorIndexOfReminderFrom)) {
              _tmpReminderFrom = null;
            } else {
              _tmpReminderFrom = _cursor.getString(_cursorIndexOfReminderFrom);
            }
            final String _tmpReminderTo;
            if (_cursor.isNull(_cursorIndexOfReminderTo)) {
              _tmpReminderTo = null;
            } else {
              _tmpReminderTo = _cursor.getString(_cursorIndexOfReminderTo);
            }
            final String _tmpReminderStatus;
            if (_cursor.isNull(_cursorIndexOfReminderStatus)) {
              _tmpReminderStatus = null;
            } else {
              _tmpReminderStatus = _cursor.getString(_cursorIndexOfReminderStatus);
            }
            final boolean _tmpIsExpand;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsExpand);
            _tmpIsExpand = _tmp != 0;
            final boolean _tmpIsArchived;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsArchived);
            _tmpIsArchived = _tmp_1 != 0;
            _item = new FriendsRemindersListModel(_tmpReminderTableId,_tmpReminderId,_tmpReminderText,_tmpReminderDate,_tmpReminderFrom,_tmpReminderTo,_tmpReminderStatus,_tmpIsExpand,_tmpIsArchived);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<FriendsRemindersListModel>> getArchivedReminders(final boolean archived) {
    final String _sql = "Select * from receivedRemindersTable where isArchived = ? order by reminderTableId DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = archived ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    return __db.getInvalidationTracker().createLiveData(new String[]{"receivedRemindersTable"}, false, new Callable<List<FriendsRemindersListModel>>() {
      @Override
      public List<FriendsRemindersListModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfReminderTableId = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderTableId");
          final int _cursorIndexOfReminderId = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderId");
          final int _cursorIndexOfReminderText = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderText");
          final int _cursorIndexOfReminderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderDate");
          final int _cursorIndexOfReminderFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderFrom");
          final int _cursorIndexOfReminderTo = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderTo");
          final int _cursorIndexOfReminderStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderStatus");
          final int _cursorIndexOfIsExpand = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpand");
          final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "isArchived");
          final List<FriendsRemindersListModel> _result = new ArrayList<FriendsRemindersListModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FriendsRemindersListModel _item;
            final int _tmpReminderTableId;
            _tmpReminderTableId = _cursor.getInt(_cursorIndexOfReminderTableId);
            final int _tmpReminderId;
            _tmpReminderId = _cursor.getInt(_cursorIndexOfReminderId);
            final String _tmpReminderText;
            if (_cursor.isNull(_cursorIndexOfReminderText)) {
              _tmpReminderText = null;
            } else {
              _tmpReminderText = _cursor.getString(_cursorIndexOfReminderText);
            }
            final String _tmpReminderDate;
            if (_cursor.isNull(_cursorIndexOfReminderDate)) {
              _tmpReminderDate = null;
            } else {
              _tmpReminderDate = _cursor.getString(_cursorIndexOfReminderDate);
            }
            final String _tmpReminderFrom;
            if (_cursor.isNull(_cursorIndexOfReminderFrom)) {
              _tmpReminderFrom = null;
            } else {
              _tmpReminderFrom = _cursor.getString(_cursorIndexOfReminderFrom);
            }
            final String _tmpReminderTo;
            if (_cursor.isNull(_cursorIndexOfReminderTo)) {
              _tmpReminderTo = null;
            } else {
              _tmpReminderTo = _cursor.getString(_cursorIndexOfReminderTo);
            }
            final String _tmpReminderStatus;
            if (_cursor.isNull(_cursorIndexOfReminderStatus)) {
              _tmpReminderStatus = null;
            } else {
              _tmpReminderStatus = _cursor.getString(_cursorIndexOfReminderStatus);
            }
            final boolean _tmpIsExpand;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsExpand);
            _tmpIsExpand = _tmp_1 != 0;
            final boolean _tmpIsArchived;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsArchived);
            _tmpIsArchived = _tmp_2 != 0;
            _item = new FriendsRemindersListModel(_tmpReminderTableId,_tmpReminderId,_tmpReminderText,_tmpReminderDate,_tmpReminderFrom,_tmpReminderTo,_tmpReminderStatus,_tmpIsExpand,_tmpIsArchived);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
