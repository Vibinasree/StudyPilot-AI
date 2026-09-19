import { Bell, Search, UserCircle } from "lucide-react";

function Navbar({ onMenuClick }) {
  const storedUser = localStorage.getItem("studypilot_user");

  let user = {};

  try {
    user = storedUser ? JSON.parse(storedUser) : {};
  } catch {
    user = {};
  }

  const displayName = user.name || user.email?.split("@")[0] || "Student";

  return (
    <header className="topbar">
      <button
        className="mobile-menu-button"
        onClick={onMenuClick}
        aria-label="Open menu"
      >
        ☰
      </button>

      <div className="topbar-search">
        <Search size={18} />

        <input
          type="text"
          placeholder="Search your workspace..."
        />
      </div>

      <div className="topbar-actions">
        <button className="icon-button" aria-label="Notifications">
          <Bell size={19} />
          <span className="notification-dot" />
        </button>

        <div className="user-mini">
          <div className="user-avatar">
            {displayName.charAt(0).toUpperCase()}
          </div>

          <div className="user-mini-info">
            <strong>{displayName}</strong>
            <span>Student</span>
          </div>

          <UserCircle size={18} className="user-outline" />
        </div>
      </div>
    </header>
  );
}

export default Navbar;