import React from 'react';
import { Menu } from 'lucide-react';

const LayoutMessagerie = ({ sidebar, chat, showSidebarMobile }) => {
    return (
        <div className="flex h-[calc(100vh-64px)] bg-gray-50 overflow-hidden">
            {/* Sidebar - Liste des conversations */}
            <div
                className={`
          w-full md:w-80 lg:w-96 bg-white border-r border-gray-100 flex-shrink-0
          transition-transform duration-300 ease-in-out z-10
          ${showSidebarMobile ? 'translate-x-0' : '-translate-x-full'}
          md:translate-x-0 absolute md:relative h-full
        `}
            >
                {sidebar}
            </div>

            {/* Zone de Chat */}
            <div className="flex-1 flex flex-col h-full bg-white relative w-full">
                {chat}
            </div>
        </div>
    );
};

import PropTypes from 'prop-types';

LayoutMessagerie.propTypes = {
    sidebar: PropTypes.node.isRequired,
    chat: PropTypes.node.isRequired,
    showSidebarMobile: PropTypes.bool,
};

export default LayoutMessagerie;
