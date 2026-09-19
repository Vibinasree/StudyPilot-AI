import { useState } from "react";
import Sidebar from "./Sidebar";
import Navbar from "./Navbar";

function Layout({ children, title, subtitle }) {
  const [mobileOpen, setMobileOpen] = useState(false);

  return (
    <div className="app-shell">
      <Sidebar
        mobileOpen={mobileOpen}
        closeSidebar={() => setMobileOpen(false)}
      />

      {mobileOpen && (
        <div
          className="sidebar-overlay"
          onClick={() => setMobileOpen(false)}
        />
      )}

      <div className="main-area">
        <Navbar onMenuClick={() => setMobileOpen(true)} />

        <main className="page-content">
          <div className="page-heading">
            <div>
              <h1>{title}</h1>

              {subtitle && (
                <p>{subtitle}</p>
              )}
            </div>
          </div>

          {children}
        </main>
      </div>
    </div>
  );
}

export default Layout;